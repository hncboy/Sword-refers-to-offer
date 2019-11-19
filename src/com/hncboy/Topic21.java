package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/10/28 14:03
 * @description 栈的压入、弹出序列
 */
public class Topic21 {

    public static void main(String[] args) {
        Topic21 topic = new Topic21();
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop1 = new int[]{4, 5, 3, 2, 1};
        int[] pop2 = new int[]{4, 3, 5, 1, 2};
        System.out.println(topic.isPopOrder(push, pop1));
        System.out.println(topic.isPopOrder(push, pop2));
    }

    private boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == popA[count]) {
                    // 上个数为出栈的数
                    stack.pop();
                    count++;
                } else if (pushA[i] == popA[count]) {
                    // 当前数为出栈的数
                    count++;
                } else {
                    // 都不是直接进栈
                    stack.push(pushA[i]);
                }
            } else {
                stack.push(pushA[i]);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != popA[count++]) {
                return false;
            }
        }

        return true;
    }
}
