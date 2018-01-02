package com.ppcredit.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {

    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);


        System.out.println(year);
    }

    /**
     * 获取当前的时间
     *
     * @return yyyy/MM/dd HH:mm:ss
     */
    public String getNowDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String new_date = dateFormat.format(date);
        System.out.println(new_date);
        return new_date;
    }

    /**
     * @return year
     */
    public int getNowYear() {

        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.get(Calendar.SUNDAY));
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

}
