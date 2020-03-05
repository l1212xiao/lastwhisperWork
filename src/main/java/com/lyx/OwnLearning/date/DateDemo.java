package com.lyx.OwnLearning.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lvyunxiao
 * @classname DateDemo
 * @description DateDemo
 * @date 2020/2/12
 */
public class DateDemo {

    /**
     * 获得当天零时零分零秒
     *
     * @return
     */
    public static long initDateByDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        return time.getTime();
    }

    /**
     * 判断当前时间在时间段以（如：7:00-22:00）
     */
    public static boolean isTimeRange(String beginDate, String endDate) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date now = null;
        Date begin = null;
        Date end = null;
        try {
            now = df.parse(df.format(new Date()));
            begin = df.parse(beginDate);
            end = df.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(now);
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(begin);
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(end);
        if (nowTime.before(endTime) && nowTime.after(beginTime)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // long l = initDateByDay();
        // System.out.println(l);
        // System.out.println("isTimeRange: " + isTimeRange("7:00", "22:00"));
        System.out.println("isTimeRange: " + isTimeRange("7:00", "11:00"));
    }

}
