package com.dgd.flume.interceptor;

import org.apache.commons.collections.CollectionUtils;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : DaiGD
 * @createtime :  2021年01月13日 17:42
 * @description :
 */
public class ETLInterceptor implements Interceptor
{
    @Override public void initialize()
    {
        
    }

    @Override public Event intercept(Event event)
    {
        String log = new String(event.getBody(), StandardCharsets.UTF_8);
        if(LogUtils.isAppLog(log)){
            return event;
        }
        return null;
    }

    @Override public List<Event> intercept(List<Event> list)
    {
        if(CollectionUtils.isNotEmpty(list)) {
            return list.stream().map(this::intercept).filter(Objects::nonNull).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    
    @Override public void close()
    {

    }
    
    
    public static class Builder implements Interceptor.Builder{
        @Override 
        public Interceptor build()
        {
            return new ETLInterceptor();
        }
        
        @Override public void configure(Context context)
        {

        }
    }
}
