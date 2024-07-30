package _5124_爬楼梯II;

/**
 * 有一个 n 阶台阶，你每一步可以爬 1个台阶 、 2 个台阶或 3 个台阶。给定 n，求有多少种不同的爬法？
 * 为了避免答案超32为整数范围，因此，在计算的过程中，答案需要与 1000000007取模，如计算结果为：1000000008，请返回 1。
 * n 范围在 [1, 100] 之间
 * 
 * @author lujinpeng
 * @date 2024-07-30 16:40
 */
public class Solution {
    public int climbStairs(int n) {
        int prevTwo = 0;
        int prevOne = 1;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int tmpCurr = curr % 1000000007;
            curr = ((prevTwo + prevOne) % 1000000007 + tmpCurr) % 1000000007;

            int tmpPrev = prevOne;
            prevOne = tmpCurr;
            prevTwo = tmpPrev;
        }
        return curr;
    }

    private int[] mem;
    public int climbStairs2(int n) {
        mem = new int[n+1];
        return climbStairs_recur(n);
    }

    private int climbStairs_recur(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (mem[n] != 0) {
            return mem[n];
        }
        mem[n] = ((climbStairs_recur(n-1) + climbStairs_recur(n-2))%1000000007 + climbStairs_recur(n-3))%1000000007;
        return mem[n];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 100; i++) {
            int res1 = solution.climbStairs(i);
            int res2 = solution.climbStairs2(i);
            if (res1 == res2) {
                continue;
            }
            System.out.println("i: " + i);
            System.out.println(res1);
            System.out.println(res2);
            break;
        } 
    }
}
