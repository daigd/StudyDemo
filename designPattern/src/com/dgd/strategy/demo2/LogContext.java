package com.dgd.strategy.demo2;

/**
 * @Author DGD
 * @date 2017/10/21.
 * 日志上下文
 */
public class LogContext {
    private LogStrategy logStrategy;


    public void log(String content) {
        try {
            logStrategy = new DbLog();
            logStrategy.log(content);
        } catch (Exception e) {
            //出现异常了采用文件来记录日志
            System.out.println("出错了!");
            logStrategy = new FileLog();
            logStrategy.log(content);
        }
    }
}
