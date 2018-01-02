package com.ppcredit.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTransfaction {

    public static final SimpleDateFormat TIME_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATEKEY_FORMAT =
            new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {
        System.out.println(getDateWithDateString("2018-11-2 15:30:26"));
    }

    /**
     * 转换为string类型
     *
     * @param dateString
     * @return
     */
    static Date getDateWithDateString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间戳转换为时间格式
     *
     * @param stam
     * @return
     * @throws ParseException
     */
    public static String stamToDate(String stam) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long timeLong = Long.parseLong(stam);
        Date date = sdf.parse(sdf.format(timeLong));
        String dat = sdf.format(date);
        return dat;
    }

    /**
     * 时间转换为时间戳格式
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        System.out.println(res);
        return res;
    }

    /**
     * (yyyyMMdd）转换为（yyyy-MM-dd）
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String transformToDateFormat(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate = formatter.parse(date);
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }

    /**
     * 获取昨天的日期（yyyy-MM-dd）
     *
     * @return 昨天的日期
     */
    public static String getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, -1);
        Date date = cal.getTime();
        return DATE_FORMAT.format(date);
    }

}
