package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 * 将数据导出成文本文件
 */
public class ExportTextFileFactory extends ExportFileAbstractFactory {
    @Override
    protected ExportFileApi createExportFileApi() {
        return new ExportTextFile();
    }
}
