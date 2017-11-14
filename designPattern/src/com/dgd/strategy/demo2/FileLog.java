package com.dgd.strategy.demo2;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 日志接口的具体实现,记录到文件中
 */
public class FileLog implements LogStrategy {
    @Override
    public void log(String content) {
        System.out.println("把日志内容:"+content+"记录到文件中去。");
    }
}
