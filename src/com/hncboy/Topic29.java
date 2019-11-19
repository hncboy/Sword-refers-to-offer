package com.hncboy;

import java.util.ArrayList;

/**
 * @author hncboy
 * @date 2019/9/27 13:55
 * @description 最小的K个数
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Topic29 {

    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new Topic29().GetLeastNumbers_Solution(input, 1));
    }

    private ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length) {
            return arrayList;
        }
        // 冒泡排序，k 为几就排几轮
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] > input[j - 1]) {
                    input[j - 1] = input[j - 1] ^ input[j];
                    input[j] = input[j - 1] ^ input[j];
                    input[j - 1] = input[j - 1] ^ input[j];
                }
            }
        }
        for (int i = input.length - 1; i >= input.length - k; i--) {
            arrayList.add(0, input[i]);
        }
        return arrayList;
    }
}
