package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/30 18:47
 * @description 剪绳子
 *
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 *
 * 示例1
 * 输入：8
 * 输出：18
 */
public class Topic67 {

    public static void main(String[] args) {
        System.out.println(new Topic67().cutRope(8));
    }

    private int cutRope(int target) {
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int[] dp = new int[target + 1];
        dp[2] = 2;
        dp[3] = 3;

        int result = 0;
        for (int i = 4; i <= target; i++) {
            // 将长度为i的绳子按 1-i/2 种切法都尝试下
            for (int j = 2; j <= i / 2; j++) {
                result = Math.max(result, dp[j] * dp[i - j]);
            }
            dp[i] = result;
        }
        return dp[target];
    }
}
