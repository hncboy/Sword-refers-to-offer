package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/8/29 17:30
 * @description 用两个栈实现队列
 * <p>
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 栈：先进后出
 * 队列：先进先出
 */
public class Topic5 {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        Topic5 topic = new Topic5();
        topic.push(1);
        topic.push(2);
        topic.push(3);
        System.out.println(topic.pop());
        System.out.println(topic.pop());
        System.out.println(topic.pop());
    }

    private void push(int node) {
        stack1.push(node);
    }

    private int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
