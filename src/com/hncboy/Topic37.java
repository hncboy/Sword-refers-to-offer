package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/19 18:25
 * @description 数字在排序数组中出现的次数
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Topic37 {

    public static void main(String[] args) {
        Topic37 topic = new Topic37();
        int[] array = {1, 2, 3, 3, 4, 5};
        System.out.println(topic.getNumberOfK(array, 0));
    }

    private int getNumberOfK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right && (array[left] != k || array[right] != k)) {
            if (array[right] > k) {
                right--;
            }
            if (array[left] < k) {
                left++;
            }
        }
        return right - left + 1;
    }
}
