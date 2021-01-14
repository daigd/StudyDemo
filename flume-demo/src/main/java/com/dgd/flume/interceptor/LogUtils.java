package com.dgd.flume.interceptor;

import org.apache.commons.lang.StringUtils;

/**
 * @author : DaiGD
 * @createtime :  2021年01月13日 17:45
 * @description : 以 "{"和"}" 开头结尾即认为是符合要求的日志内容
 */
public class LogUtils
{
    public static boolean isAppLog(String log)
    {
        if(StringUtils.isBlank(log))
        {
            return false;
        }
        return log.startsWith("{") && log.endsWith("}");
    }
}
