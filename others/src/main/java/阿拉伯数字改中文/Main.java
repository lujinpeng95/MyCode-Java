package 阿拉伯数字改中文;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:08 下午
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Solution01.toChinese(123456789));
        System.out.println(Solution01.toChinese(1001));
        System.out.println(Solution01.toChinese(200000));
        System.out.println(Solution01.toChinese(0));

        System.out.println(Solution02.toChineseNumber(123456789));
        System.out.println(Solution02.toChineseNumber(1000));
        System.out.println(Solution02.toChineseNumber(201030));
        System.out.println(Solution02.toChineseNumber(0));
    }
}
