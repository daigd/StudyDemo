package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class ExportDbFileFactory extends ExportFileAbstractFactory {
    @Override
    protected ExportFileApi createExportFileApi() {
        return new ExportDbFile();
    }
}
