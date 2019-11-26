package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/26 13:29
 * @description 数组中只出现一次的数字
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Topic40 {

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        new Topic40().findNumsAppearOnce(array, new int[1], new int[1]);
    }

    private void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int sum = 0;
        // 遍历所有的数，相同的数异或为0，得到的结果为两个只出现一次的数的异或值
        for (int num : array) {
            sum ^= num;
        }

        int i = 0;
        // 遍历所有32位整数，找到一位和 sum按位与值不为0的数，也就时该位为1的数
        // 因为两个不同的数异或不为0，一定有个数该位上为1，另一个为0
        while (i < 32 && (sum & (1 << i)) == 0) {
            i++;
        }

        // 重新遍历所有数，根据该数 &(1<<i) 的值将所有数划分成两部分
        // 每一部分都包含只出现一次的数且出现两次的数都在同一边
        for (int num : array) {
            if ((num & (1 << i)) != 0) {
                num2[0] ^= num;
            } else {
                num1[0] ^= num;
            }
        }
    }
}
