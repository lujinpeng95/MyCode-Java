package 阿拉伯数字改中文;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:07 下午
 */
public class Solution01 {
    private static final String[] CHINESE_NUMBERS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CHINESE_INTEGER_UNITS = {"", "十", "百", "千", "万", "十", "百", "千", "亿"};

    public static String toChinese(int number) {
        String strNumber = String.valueOf(number);
        String result = "";
        int length = strNumber.length();

        for (int i = 0; i < length; i++) {
            int digit = strNumber.charAt(i) - '0';
            String chineseNumber = CHINESE_NUMBERS[digit];
            String chineseUnit = CHINESE_INTEGER_UNITS[length - i - 1];

            // 根据中文习惯，四位数不会以一十开头，如：1000 => 一千，不是一十千
            if (digit == 1 && "十".equals(chineseUnit) && i == 0) {
                result += chineseUnit;
            } else {
                result += chineseNumber + chineseUnit;
            }
        }

        // 处理连续的零（1~n个0，取代为一个0）
        result = result.replaceAll("零+", "零");

        // 处理结尾的零（去掉末尾的零）
        result = result.replaceAll("零$", "");

        return result;
    }
}
