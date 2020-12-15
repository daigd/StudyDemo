import os,sys

def main():
    """
    输出指定路径下所有文件的绝对路径
    """
    if len(sys.argv) != 2:
        print("请输入指定目录")
        sys.exit(2)
    
    pathName = sys.argv[1]
    print("指定目录名:%s" % pathName)
    for root,dirs,files in os.walk(pathName):
        for name in files:
            print("文件%s的绝对路径==>%s\n" % (name,os.path.join(root,name)))

if __name__ == "__main__":
    main()            