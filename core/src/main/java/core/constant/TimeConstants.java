package core.constant;

/**
 * @author maguilong on 2022/8/18
 **/
public class TimeConstants {

    public static final Integer SEC_IN_DAY = 86400;

    public static final Integer MILS_SEC_IN_DAY = 86400000;

    public static final Integer MILS_SEC_IN_HOUR = 3600000;

    /**
     * 一周的毫秒数
     */
    public static final Long MILS_SEC_IN_WEEK = MILS_SEC_IN_DAY * 7L;

    /**
     * 三个月的毫秒数
     */
    public static final Long MILS_SEC_IN_QUARTER = MILS_SEC_IN_DAY * 93L;
}
