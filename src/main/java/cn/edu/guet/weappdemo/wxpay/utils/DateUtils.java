package cn.edu.guet.weappdemo.wxpay.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String YYYY_MM_DD_HH_MM = "yyyy年MM月dd日 HH:mm";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }
    //计算两个时间相差多少秒
    public static long getDatePoor(LocalDateTime startDate, LocalDateTime endDate) {
        long start = startDate.toEpochSecond(ZoneOffset.of("+8"));
        long end = endDate.toEpochSecond(ZoneOffset.of("+8"));
        return end - start;
    }
    public static String format(LocalDateTime localDateTime,String format){
        return DateTimeFormatter.ofPattern(format).format(localDateTime);
    }
    public static LocalDateTime parse(String dateTime,String format){
        return LocalDateTime.parse(dateTime,DateTimeFormatter.ofPattern(format));
    }
    public static String format(LocalDateTime localDateTime){
        return format(localDateTime,YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 计算时间
     * @param date
     * @param time
     * @param type
     * @return
     */
    public static LocalDateTime computeDate(LocalDateTime date,long time,Type type){
        LocalDateTime newDate = null;
        switch (type){
            case YEAR:
                newDate = time>0?date.plusYears(time):date.minusYears(Math.abs(time));
                break;
            case MONTH:
                newDate = time>0?date.plusMonths(time):date.minusMonths(Math.abs(time));
                break;
            case WEEK:
                newDate = time>0?date.plusWeeks(time):date.minusWeeks(Math.abs(time));
                break;
            case DAY:
                newDate = time>0?date.plusDays(time):date.minusDays(Math.abs(time));
                break;
            case HOUR:
                newDate = time>0?date.plusHours(time):date.minusHours(Math.abs(time));
                break;
            case MINUTE:
                newDate = time>0?date.plusMinutes(time):date.minusMinutes(Math.abs(time));
                break;
            case SECOND:
                newDate = time>0?date.plusSeconds(time):date.minusSeconds(Math.abs(time));
                break;
            case NANO:
                newDate = time>0?date.plusNanos(time):date.minusNanos(Math.abs(time));
                break;
        }
        return newDate;
    }
            public enum Type{
        YEAR,
        MONTH,
        WEEK,
        DAY,
        HOUR,
        MINUTE,
        SECOND,
        NANO;
    }

    /**
     * 比较两日期大小
     *
     * @param date      日期
     * @param otherDate 另一个日期
     * @return 比较两日期大小。如果date>otherDate则返回true,否则false
     */
    public static Boolean compare(Date date, Date otherDate) {
        return date.getTime() > otherDate.getTime();
    }
    public static Boolean compare(LocalDateTime date, LocalDateTime otherDate) {
        long time1 = date.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        long time2 = otherDate.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        return time1 > time2;
    }

    public static void main(String[] args) {
        LocalDateTime time = computeDate(LocalDateTime.now(), 10, Type.MINUTE);

        System.out.println(format(time,YYYY_MM_DD_HH_MM_SS));
        System.out.println(DateUtils.getTime());
    }

}
