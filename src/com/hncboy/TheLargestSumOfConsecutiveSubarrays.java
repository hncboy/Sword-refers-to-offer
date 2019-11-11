package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/11 14:08
 * @description 连续子数组的最大和
 * <p>
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？
 * <p>
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class TheLargestSumOfConsecutiveSubarrays {

    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray(array));
    }

    private static int findGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = 0;
            // 如果数组中正数，那么最大子序列的头部和尾部肯定是正数
        for (int num : array) {
            // 如果和变为了负数则从当前数重新计算和，因为如果都是负数的话，只需要单独比较每个负数的大小
            sum = sum > 0 ? sum + num : num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
