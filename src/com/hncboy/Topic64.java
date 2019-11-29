package com.hncboy;

import java.util.ArrayList;

/**
 * @author hncboy
 * @date 2019/11/29 15:45
 * @description 滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Topic64 {

    public static void main(String[] args) {
        System.out.println(new Topic64().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }

    private ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0) {
            return new ArrayList<>();
        }
        int[] windowMax = new int[num.length - size + 1];

        // 当前滑动窗口的最大值下标
        int currentMaxIndex = -1;
        int left = 0;
        int right = size - 1;

        while (right < num.length) {
            // 当前最大数的下标在滑动窗口内的话就直接取最大值
            if (currentMaxIndex >= left) {
                windowMax[left] = num[currentMaxIndex];
            } else {
                // 否则重新计算当前窗口内的最大值
                currentMaxIndex = left;
                for (int i = left; i < left + size; i++) {
                    if (windowMax[left] <= num[i]) {
                        windowMax[left] = num[i];
                        currentMaxIndex = i;
                    }
                }
            }

            left++;
            right++;

            // 如果下一数大于当前窗口中的最大数，替换下标
            if (right < num.length) {
                if (num[currentMaxIndex] <= num[right]) {
                    currentMaxIndex = right;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int max : windowMax) {
            result.add(max);
        }
        return result;
    }
}
