package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 * 将数据导出到数据库中
 */
public class ExportDbFileFactory extends ExportFileAbstractFactory {
    @Override
    protected ExportFileApi createExportFileApi() {
        return new ExportDbFile();
    }
}
