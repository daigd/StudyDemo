package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class ExportXmlFileFactory extends ExportFileFactory {

    @Override
    protected ExportFileApi createFileApi(int type) {
        if (3 == type) {
            return new ExportXmlFile();
        }
        return super.createFileApi(type);
    }
}
