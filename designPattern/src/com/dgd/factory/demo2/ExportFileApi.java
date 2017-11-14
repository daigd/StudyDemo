package com.dgd.factory.demo2;

/**
 * @Author DGD
 * @date 2017/10/26.
 */
public interface ExportFileApi {
    /**
     * 导出内容成为文件
     * @param data 文件内容
     * @return 是否导出成功
     */
    boolean export(String data);
}
