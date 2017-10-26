package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public class ExportFileFactory {
    public boolean export(int type,String data){
        ExportFileApi api = createFileApi(type);
        if (api != null) {
            return api.export(data);
        }
        return false;
    }

    protected ExportFileApi createFileApi(int type) {
        if (1 == type) {
            return new ExportTextFile();
        } else if (2 == type) {
            return new ExportDbFile();
        }
        return null;
    }
}
