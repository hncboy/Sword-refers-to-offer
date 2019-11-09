package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/9 8:50
 * @description 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class NumberOfOccurrencesInTheArrayThatExceedsHalf {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(array));
    }

    private static int moreThanHalfNum(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            count = array[i] == num ? count + 1 : count - 1;
            if (count == 0) {
                // 如果 num 出现的次数超过一半，count>=1
                num = array[i];
                count = 1;
            }
        }

        count = 0;
        // 验证 num
        for (int value : array) {
            if (value == num) {
                count++;
            }
        }
        return count > array.length / 2 ? num : 0;
    }
}
