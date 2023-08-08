package 阿拉伯数字改中文;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:08 下午
 */
public class Solution02 {
    private static final String[] CHINESE_NUMBERS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
//    private static final String[] CHINESE_UNIT = {"", "拾", "佰", "仟", "万", "亿"};
    private static final String[] CHINESE_UNIT = {"", "十", "百", "千", "万", "十", "百", "千", "亿"};

    public static String toChineseNumber(int num) {
        if (num == 0) {
            return CHINESE_NUMBERS[0];
        }

        StringBuilder sb = new StringBuilder();
        int unitIndex = 0;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                if (sb.length() > 0 && sb.charAt(0) != '零') {
                    sb.insert(0, CHINESE_NUMBERS[digit]);
                }
            } else {
                sb.insert(0, CHINESE_NUMBERS[digit] + CHINESE_UNIT[unitIndex]);
            }
            num /= 10;
            unitIndex++;
        }

        return sb.toString();
    }
}
