package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 18:32
 * @description 数组中重复的数字
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Topic50 {

    public static void main(String[] args) {
        System.out.println(new Topic50().duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, new int[1]));
    }

    private boolean duplicate(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            if (numbers[Math.abs(numbers[i])] < 0) {
                duplication[0] = -numbers[Math.abs(numbers[i])];
                return true;
            }
            numbers[Math.abs(numbers[i])] *= -1;
        }
        return false;
    }
}
