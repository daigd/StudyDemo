from urllib import request
import chardet
import codecs

def main():
    """
    抓取web页面
    """
    print("抓取web页面,将内存保存到文本文件中\n")

    res = request.urlopen("http://www.baidu.com")
    html = res.read()
    charset = chardet.detect(html)
    print(charset)
    encoding = charset['encoding']
    print("网页编码: %s" % encoding)
    html2 = html.decode(encoding)
    print("网页内容长度:%d" % len(html2))

    with codecs.open("./web.txt","w",encoding) as f:
        f.write(html2)

    print("操作完成！")

if __name__ == "__main__":
    main()