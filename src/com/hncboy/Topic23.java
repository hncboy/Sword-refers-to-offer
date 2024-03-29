package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/10/28 14:49
 * @description 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Topic23 {

    public static void main(String[] args) {
        int[] sequence = new int[]{2, 4, 3, 6, 8, 7, 5};
        System.out.println(new Topic23().verifySequenceOfBST(sequence));
    }

    private boolean verifySequenceOfBST(int[] sequence) {
        int length = sequence.length;
        if (length == 0) {
            return false;
        }
        // 根节点
        int root = sequence[length - 1];

        int i = 0;
        for (; i < length - 1; i++) {
            // 右子树第一个节点
            if (sequence[i] > root) {
                for (int j = i; j < length - 1; j++) {
                    // 右子树的节点小于根节点
                    if (sequence[j] < root) {
                        return false;
                    }
                }
                break;
            }
        }

        boolean left = true;
        boolean right = true;

        if (i > 0) {
            left = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        if (i < length - 1) {
            right = verifySequenceOfBST(Arrays.copyOfRange(sequence, i, length - 1));
        }

        return left && right;
    }
}
