package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 * 该类定义成抽象类,因为接口不能有方法的实现
 */
public abstract class ExportFileAbstractFactory {
    public boolean export(String data){
        return createExportFileApi().export(data);
    }

    //这个时候并不知道对象的具体实现
    protected abstract ExportFileApi createExportFileApi();
}
