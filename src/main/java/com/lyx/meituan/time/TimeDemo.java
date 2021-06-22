package com.lyx.meituan.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author lvyunxiao
 * @date 2021/2/22
 * @description
 */
public class TimeDemo {

    public static void main(String[] args) {
        // 获取秒数时间戳（10位）
        LocalDateTime.now().toInstant(ZoneOffset.of("+8")).getEpochSecond();

        // 获取毫秒数时间戳（13位）
        LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        final long nowMillis = System.currentTimeMillis();
        //System.out.println(nowMillis);
        long time = 1613923200000L;
        final long converttouserreceiveclock = convertToUserReceiveClock(time);
        System.out.println(converttouserreceiveclock);
    }

    /**
     * 转化为当天用户的自提时间点,目前是16点
     */
    public static long convertToUserReceiveClock(long timeStamp) {
        final LocalDateTime localDateTime = LocalDateTime
            .ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault());
        final LocalDateTime dayStart = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN);
        return dayStart.withHour(16).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

}
