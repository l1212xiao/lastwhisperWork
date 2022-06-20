package com.lyx.meituan.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author lvyunxiao
 * @date 2022/4/14
 * @description
 */
public class DayOfYear {

    public static final String GROUP_FULFILLMENT_IN_OUT_RECORD_TYPE = "dts_group_fulfillment_in_out_record";

    public static final String GROUP_FULFILLMENT_IN_OUT_RECORD_INDEX_FORMAT = "dts_group_fulfillment_in_out_record_1__%s_%s";


    public static LocalDateTime getLocalDateTime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

    public static LocalDate getLocalDate(long timestamp) {
        return getLocalDateTime(timestamp).toLocalDate();
    }

    private static String getInOutRecordType(long preArrivalStartTime) {
        LocalDate localDate = getLocalDate(preArrivalStartTime);
        return String
            .format(GROUP_FULFILLMENT_IN_OUT_RECORD_INDEX_FORMAT, localDate.getYear(), localDate.getDayOfYear());
    }

    // public static void main(String[] args) {
    //     System.out.println(getInOutRecordType(1650816000000L));
    // }

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH_MM_SS = YYYY_MM_DD + " HH:mm:ss";

    public static LocalDateTime parseStringToLocalDateTime(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        return LocalDateTime.parse(date, df);
    }

    public static long getTimestapmOfDaysAgo(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    public static Long localTime2EpochMilli(LocalDateTime localDateTime) {

        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static void main(String[] args) {
        // LocalDate localDate = LocalDate.now();
        // System.out.println(localDate.getYear() + ":" + localDate.getDayOfYear() + ":" + localDate.getMonth());
        String preArrivalTime = "2022-06-20";
        System.out.println(preArrivalTime.length());
        if (preArrivalTime.length() <= 10) {
            preArrivalTime += " 00:00:00";
        }
        LocalDateTime pTime = parseStringToLocalDateTime(preArrivalTime);
        if (localTime2EpochMilli(pTime) < getTimestapmOfDaysAgo(2)) {
            System.out.println(" Filter ");
        } else {
            System.out.println(" yes");
        }

    }
}
