package _70_爬楼梯;

/**
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？（1 <= n <= 45）
 * 
 * @author lujinpeng
 * @date 2024-07-30 15:10
 */
class Solution {
    private int[] memo;

    /**
     * 法一：备忘录
     *
     * @param n 楼梯的总级数
     * @return 到达第n级楼梯的不同走法数
     */
    public int climbStairs(int n) {
        memo = new int[n+1];
        return recursion(n);
    }

    /**
     * 法二：动态规划
     *
     * @param n 楼梯的总级数
     * @return 到达第n级楼梯的不同走法数
     */
    public int climbStairs2(int n) {
        int prev = 1;
        int curr = 1;
        
        for (int i = 2; i <= n; i++) {
            int tmp = curr;
            curr += prev;
            prev = tmp;
        }
        return curr;
    }

    private int recursion(int i) {
        if (i == 1 || i == 2) {
            return i;
        }

        if (memo[i] != 0) {
            return memo[i];
        }
        memo[i] = recursion(i - 1) + recursion(i -2);
        return memo[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
