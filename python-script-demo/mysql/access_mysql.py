import paramiko
import pymysql
import pandas as pd
from sshtunnel import SSHTunnelForwarder
import time
import openpyxl

# 使用私钥文件和密码短语生成 ssh_pkey
mypkey = paramiko.RSAKey.from_private_key_file('', password='')
ssh_remote_host = "" # ssh访问主机名
ssh_remote_port = 22 # ssh访问端口
ssh_login_username = "" # ssh 登录用户名
remote_bind_address_host = "" # 远程访问的主机名,当前需求写数据库访问地址
remote_bind_address_port = 3306 # 远程访问的端口

mysql_user = ""
mysql_passwd = ""
mysql_db = "" # 指定访问的数据库

def main():

    """
    需求：通过 SSH 访问远程数据库，读取大量数据，同步到本地数据库中

    参考文档：
    python远程操作Linux——使用paramiko库：https://zhuanlan.zhihu.com/p/136573027
    Pandas行转列，列转行,以及一行生成多行: https://www.cnblogs.com/traditional/p/11967360.html
    Pandas 通过索引提取dataframe的行: https://blog.csdn.net/yyhhlancelot/article/details/82257985
    """
    print("通过 SSH 访问远程数据库,开始执行脚本……")

    with SSHTunnelForwarder(
        (ssh_remote_host, ssh_remote_port),  # 指定ssh登录的跳转机的address，端口号
        ssh_username=ssh_login_username,  # 跳转机的用户
        ssh_pkey=mypkey,
        remote_bind_address=(remote_bind_address_host, remote_bind_address_port) # 需要访问的远程数据库地址
    ) as tunnel:  # mysql服务器的address，端口号
        conn = pymysql.connect(host='127.0.0.1', # 此处 host 必须是127.0.0.1
                            port=tunnel.local_bind_port, # 获取映射端口
                            user=mysql_user,passwd=mysql_passwd, db=mysql_db)
        # 读取大批量文件时，采用游标方式
        startTime = time.time()
        cursor = pymysql.cursors.SSCursor(conn)
        
        # begin_time,end_time,`status`,source_channel,issued_channel,camp_type,role_type
        sql = """
        select id,code,cmpn_id,cust_id from vm_campaign.campaign_instance 
        where 1=1 limit 10;
        """
        cursor.execute(sql)

        columnDes = cursor.description #获取连接对象的描述信息
        columnNames = [columnDes[i][0] for i in range(len(columnDes))] # 获取数据库列名
        
        row = cursor.fetchone() # 每次读取一行记录
        while row is not None:
            # 获取的row是包含多个元素的元组,要将该元组变成一行,加上 [] 即可
            df = pd.DataFrame([row],columns=columnNames)
            # print(df)
            # header=False,index=False : 字段名和索引不写入到 csv 文件中
            df.to_csv("./test.csv",mode="a",header=False,index=False)
            #df.to_excel('./test.xlsx',header=False,index=False) 
            #with pd.ExcelWriter('./test.xlsx',mode='a') as writer:
               # df.to_excel(writer)

            row = cursor.fetchone()

        stopTime = time.time()
        print("数据写入到本地文件任务完成,耗时:%d毫秒" % (stopTime-startTime))
        cursor.close()
        conn.close()

if __name__ == "__main__":
    main()