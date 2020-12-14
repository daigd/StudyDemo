import sys
import codecs
"""
读取一个文件内容,写入到另一个文件中
第一个参数为读取文件的路径,第二个参数为写入文件的路径
使用示例：
python read_file_to_another_file.py file1.txt file2.txt 
"""
def main():
    # 参考：Python获取命令行参数的方法
    # https://blog.csdn.net/ouyang_peng/article/details/79390920
    print("输入参数个数:%d" % len(sys.argv))
    # 判断输入的参数个数
    if len(sys.argv)!=3:
        print("参数个数不对!\n")
        sys.exit(2)
    readFile = sys.argv[1]
    writeFile = sys.argv[2]
    print("读取文件为:%s,写入文件为:%s" % (readFile,writeFile))

# 参考：Python 读取大文件
# https://blog.csdn.net/liang19890820/article/details/78206736
# Python3--文件读取、写入、追加及seek()方法的使用 
# https://blog.csdn.net/m0_37422217/article/details/77035323
# 使用 codecs 对文件进行编码解码处理
# 参考：python读写不同编码txt文件
# https://blog.csdn.net/zm2714/article/details/8012474
    with codecs.open(readFile,'r','utf-8') as f:
        # 逐行读取
        for line in f:
            # 以追加的模式逐行写入
            with codecs.open(writeFile,'a','utf-8') as wf:
                wf.write(line)
                # 换行
                #wf.write('\n')

# __name__ 含义说明：参考：如何简单地理解Python中的if __name__ == '__main__'
# https://blog.csdn.net/yjk13703623757/article/details/77918633
if __name__ == "__main__":
    main()

