package _5121_斐波那契数列;

/**
 * 【注】同 leetCode 的 70爬楼梯
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1。F(1) = 1, F(2)=1
 * 
 * 为了避免答案超32为整数范围，因此，在计算的过程中，答案需要与 1000000007 取模，如计算结果为：1000000008，请返回 1。
 * 
 * @author lujinpeng
 * @date 2024-07-30 15:47
 */
public class Solution {
    public int fibonacci(int n) {
        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = curr % 1000000007;
            curr = (prev + curr) % 1000000007;
            prev = tmp;
        }
        return curr;
    }
}
