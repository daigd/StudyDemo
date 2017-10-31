package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class Client {
    public static void main(String[] args) {
        //将数据导出成文本文件
        ExportFileAbstractFactory factory = new ExportTextFileFactory();
        factory.export("123");

        //将数据导出到数据库中
        factory = new ExportDbFileFactory();
        factory.export("DB");

        //使用参数化的工厂方法
        ExportFileFactory fileFactory = new ExportXmlFileFactory();
        fileFactory.export(3, "test");
    }
}
