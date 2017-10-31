package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/31.
 */
public class ExportFatory {
    //提供文本文件功能导出的实例
    public static ExportFileApi createExportFileApi() {
        return new ExportTextFile();
    }
}
