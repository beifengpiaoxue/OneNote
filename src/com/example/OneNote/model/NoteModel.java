package com.example.OneNote.model;

import java.util.Date;

/**
 * Created by Administrator on 2014/12/19.
 */
public class NoteModel {
    private String id;
    private Date date;
    private String planMessage;
    private String dayHarvest;
    public NoteModel(){
        id=System.currentTimeMillis()+"";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanMessage() {
        return planMessage;
    }

    public void setPlanMessage(String planMessage) {
        this.planMessage = planMessage;
    }

    public String getDayHarvest() {
        return dayHarvest;
    }

    public void setDayHarvest(String dayHarvest) {
        this.dayHarvest = dayHarvest;
    }
}
