package core.util;


import core.exception.TimeFormatException;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    /**
     * 获取当前的时间（秒）
     *
     * @return
     */
    public static long getCurrentSeconds() {
        return System.currentTimeMillis() / 1000L;
    }

    /**
     * 获取当前的时间戳（毫秒）
     *
     * @return 毫秒时间戳
     */
    public static long getCurrentMilliSeconds() {
        return System.currentTimeMillis();
    }

    /**
     * 获取几个月前的时间戳（单位：秒）
     *
     * @param aheadMonth
     *
     * @return
     */
    public static long getAheadSecond(int aheadMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -aheadMonth);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() / 1000L;
    }

    /**
     * 获取指定时间前的时间戳（单位：毫秒；13位）
     *
     * @param monthsAgo  指定提前月数
     * @param daysAgo    指定提前天数
     * @param hoursAgo   指定提前小时数
     * @param minutesAgo 指定提前分钟数
     * @return
     */
    public static long getAheadTime(int monthsAgo, int daysAgo, int hoursAgo, int minutesAgo) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -monthsAgo);
        calendar.add(Calendar.DAY_OF_MONTH, -daysAgo);
        calendar.add(Calendar.HOUR_OF_DAY, -hoursAgo);
        calendar.add(Calendar.MINUTE, -minutesAgo);

        return calendar.getTimeInMillis();
    }

    /**
     * 将"yyyy-MM-dd HH:mm:ss"格式的时间字符串转换成秒
     *
     * @param date
     *
     * @return
     */
    public static Long formatTimeInStr(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parsedDate = formatter.parse(date);
            return parsedDate.getTime() / 1000L;
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 将秒转换成HH:mm:ss
     *
     * @param second
     *
     * @return 返回时分秒
     */
    public static String secondToTime(Long second) {
        String result = "00:00:00";
        if (second <= 0) {
            Long hours = second / 3600; // 转换小时数
            second = second % 3600;     // 剩余秒数
            Long minutes = second / 60; // 转换分钟
            second = second % 60;       // 剩余秒数
            String hoursStr = hours > 9 ? hours.toString() : ("0" + hours.toString());
            String minutesStr = minutes > 9 ? minutes.toString() : ("0" + minutes.toString());
            String secondStr = second > 9 ? second.toString() : ("0" + second.toString());

            result = hoursStr + ":" + minutesStr + ":" + secondStr;
        }
        return result;
    }


    /**
     * 获取字符串"yyyy-MM-dd HH:mm:ss"格式的当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(dateTimeFormatter);
    }

    /**
     * 获取当天零点的时间戳(秒)
     *
     * @return
     */
    public static Long getEpochSecondToday() {
        return LocalDate.now().atStartOfDay().atZone(ZoneOffset.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 格式化时间
     * @param ms
     * @param pattern
     * @return
     */
    public static String formatDateTime(long ms, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date(ms).toInstant(), ZoneOffset.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将日期转换为yyyyMMdd的整型
     * @param day 需要转换的日期
     * @return
     */
    public static Integer formatDateInteger(String day) {
        String dateString;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            // 若不传日期，查询基准时间为当前日期前三天
            if (day == null || day.length() <= 0) {
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_MONTH, -3);
                dateString = df.format(calendar.getTime().getTime());
            } else {
                dateString = df.format(day);
            }
            return Integer.parseInt(dateString);
        } catch (Exception e) {
            throw new TimeFormatException("查询日期转换错误");
        }
    }


    /**
     * 将用户传进来的日期转换为Integer类型
     * @param day 需要转换的日期
     * @return
     */
    public static Integer formatDateToInteger(String day){
        if (day != null && day.length() != 0){
            return Integer.valueOf(day);
        }
        try {
            Integer dateString;
            SimpleDateFormat tmp = new SimpleDateFormat("yyyyMMdd");
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -3);
            dateString = Integer.valueOf(tmp.format(calendar.getTime().getTime()));
            return dateString;
        } catch (Exception e) {
            throw new TimeFormatException("查询日期转换错误");
        }
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss.SSS转为Date
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date strToTime(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(str);
    }

    /**
     * yyyy-MM-dd HH:mm:ss.SSS字符串
     * @param date
     * @return
     * @throws ParseException
     */
    public static String dateToStr(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return dateFormat.format(date);
    }

    /**
     * 将1607428426.366 转为 2020-12-8 19:53:46.366
     * @param dataVersion
     * @return
     */
    public static String parseDataVersion(String dataVersion) {
        if (StringUtils.isEmpty(dataVersion)) {
            return null;
        }
        String[] versions = dataVersion.split("\\.");
        Date date = new Date(Long.valueOf(versions[0]) * 1000L);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date) + "." + versions[1];
    }
}
