package com.dgd.strategy.demo1;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 日志接口的具体实现：记录到数据库中
 */
public class DbLog implements LogStrategy {
    @Override
    public void log(String content) {
        //模拟异常情况
        if (content != null && content.length() > 5) {
            int a = 5/0;
        }
        System.out.println("把日志内容:"+content+"记录到数据库中。");
    }
}
