package com.dgd.thread.java7concurrencycookbook.chapter1;

import java.util.Date;

/**
 * @Author DGD
 * @date 2018/3/12.
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
