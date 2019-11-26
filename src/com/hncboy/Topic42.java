package com.hncboy;

import java.util.ArrayList;

/**
 * @author hncboy
 * @date 2019/11/26 14:54
 * @description 和为S的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class Topic42 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {1, 2, 4, 7, 11, 16};
        System.out.println(new Topic42().findNumbersWithSum(array1, 10));
        System.out.println(new Topic42().findNumbersWithSum(array2, 10));
    }

    private ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        int left = 0;
        int right = array.length - 1;
        ArrayList<Integer> result = new ArrayList<>();

        while (left < right) {
            if (array[left] + array[right] > sum) {
                right--;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                // 第一组的乘积一定最小
                result.add(array[left]);
                result.add(array[right]);
                return result;
            }
        }
        return result;
    }
}
