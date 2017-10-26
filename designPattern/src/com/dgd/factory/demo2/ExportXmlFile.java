package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class ExportXmlFile implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.println("导出数据"+data+"到xml文件");
        return true;
    }
}
