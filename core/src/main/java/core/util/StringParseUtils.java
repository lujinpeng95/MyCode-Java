package core.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * StringParseUtils
 *
 * @author lujinpeng
 * @date 2022/12/06 15:16
 */
public class StringParseUtils {

    /**
     * 字符串添加掩码。若字符串为null/空字符串，或者掩码符号为null，则原字符串返回
     *
     * @param str 待操作的字符串
     * @param retainLenBefore 保留字符串前retainLenBefore个位数，若为null，则该值为0
     * @param retainLenBehind 保字符串后retainLenBehind个位数，若为null，则该值为0
     * @param replaceStr 掩码符号
     * @param repeat 掩码符号重复次数。若为null，则按字符串实际长度添加
     * @return 添加掩码后的字符串
     */
    public static String maskStr(String str, Integer retainLenBefore, Integer retainLenBehind,
                                 String replaceStr, Integer repeat) {
        if (StringUtils.isBlank(str) || Objects.isNull(replaceStr)) {
            return str;
        }
        // 若入参为null，取值为0
        retainLenBefore = Objects.nonNull(retainLenBefore) ? retainLenBefore : 0;
        retainLenBehind = Objects.nonNull(retainLenBehind) ? retainLenBehind : 0;

        int strLen = str.length();
        int retainLen = retainLenBefore + retainLenBehind;
        // 不大于指定明文长度，直接返回原字符串
        if (str.length() <= retainLen) {
            return str;
        }

        String maskStr;
        if (Objects.isNull(repeat)) {
            maskStr = StringUtils.repeat(replaceStr, strLen - retainLen);
        } else {
            maskStr = StringUtils.repeat(replaceStr, repeat);
        }

        return str.substring(0, retainLenBefore) + maskStr + str.substring(strLen - retainLenBehind);
    }
}