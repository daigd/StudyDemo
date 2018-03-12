package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class MyThreadfactory implements ThreadFactory {
    private int count;
    private String name;
    private List<String> stats;

    public MyThreadfactory(String name) {
        this.count = 0;
        this.name = name;
        this.stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread_" + count);
        count++;
        stats.add(String.format("Created thread %d with name %s on %s\n", thread.getId(), thread.getName(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        return thread;
    }

    public String getStats() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> iterator = stats.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
