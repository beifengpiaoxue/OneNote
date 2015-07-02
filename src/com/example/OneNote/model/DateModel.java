package com.example.OneNote.model;

import java.util.Date;

/**
 * Created by Administrator on 2014/12/19.
 */
public class DateModel {
    private Date date;
    private boolean isThisMonth;
    private boolean isToday;
    private int week;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isThisMonth() {
        return isThisMonth;
    }

    public void setThisMonth(boolean isThisMonth) {
        this.isThisMonth = isThisMonth;
    }

    public boolean isToday() {
        return isToday;
    }

    public void setToday(boolean isToday) {
        this.isToday = isToday;
    }

}
