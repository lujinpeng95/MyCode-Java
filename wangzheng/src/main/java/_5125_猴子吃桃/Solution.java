package _5125_猴子吃桃;

/**
 * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃 了一个。第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下的一半多一个，到第 n 天早上想再吃时，见只剩下一个桃子了，给定 n 值，计算最初有多少个桃子。1<= n <=20
 * 
 * @author lujinpeng
 * @date 2024-07-30 16:57
 */
public class Solution {
    public int eatPeaches(int nDays) {
        if (nDays == 1) {
            return 1;
        }
        return (eatPeaches(nDays-1) + 1) * 2;
    }
}