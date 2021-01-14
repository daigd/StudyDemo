package com.dgd.flume.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : DaiGD
 * @createtime :  2021年01月13日 18:25
 * @description : 将日志时间戳设置到 header中
 */
public class TimeStampInterceptor implements Interceptor
{
    @Override public void initialize()
    {
        
    }

    @Override 
    public Event intercept(Event event)
    {
        String log = new String(event.getBody(), StandardCharsets.UTF_8);
        JSONObject json = JSONObject.parseObject(log);

        Map<String, String> headers = event.getHeaders();
        headers.put("ts", json.getString("ts"));

        return event;
    }

    @Override public List<Event> intercept(List<Event> list)
    {
        if(CollectionUtils.isNotEmpty(list)) {
            return list.stream().map(this::intercept).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override public void close()
    {

    }

    public static class Builder implements Interceptor.Builder{
        @Override public Interceptor build()
        {
            return new TimeStampInterceptor();
        }

        @Override public void configure(Context context)
        {

        }
    }
    
}
