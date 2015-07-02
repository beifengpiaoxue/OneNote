package com.example.OneNote.util;

import com.example.OneNote.model.DateModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2014/12/19.
 */
public class DateUtil {

    public static ArrayList<DateModel> getDates(Calendar calendar){
        ArrayList<DateModel> dateModels=new ArrayList<DateModel>();
        Calendar todayCalendar=Calendar.getInstance();
        //当前年月日
        int thisYear=calendar.get(Calendar.YEAR);
        int thisMonth=calendar.get(Calendar.MONTH);

        //获取每月1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int weekDay=calendar.get(Calendar.DAY_OF_WEEK);

        //确定日历的起始日期
        if(weekDay>1){
            calendar.add(Calendar.DAY_OF_YEAR,-(weekDay-1));
        }else{
            weekDay =8;
            calendar.add(Calendar.DAY_OF_YEAR,-(weekDay-1));
        }

        //获的日历一页的信息
        for(int i=0;i<42;i++){
            DateModel dateModel=new DateModel();
            dateModel.setDate(calendar.getTime());
            dateModel.setWeek(calendar.get(Calendar.DAY_OF_WEEK));
            if(calendar.get(Calendar.YEAR) == thisYear){
                if(calendar.get(Calendar.MONTH) == thisMonth){
                    dateModel.setThisMonth(true);
                }else{
                    dateModel.setThisMonth(false);
                }
            }else{
                dateModel.setThisMonth(false);
            }


            if(todayCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)&&
                        todayCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)&&
                        todayCalendar.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)){
                dateModel.setToday(true);
            }else{
                dateModel.setToday(false);
            }

            calendar.add(Calendar.DAY_OF_YEAR,1);
            dateModels.add(dateModel);
        }

        calendar.add(Calendar.DAY_OF_YEAR,weekDay-43);
        return dateModels;
    }

}
