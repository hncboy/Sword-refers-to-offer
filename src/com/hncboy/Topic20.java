package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/9/27 19:06
 * @description 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Topic20 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    public static void main(String[] args) {
        Topic20 topic = new Topic20();
        topic.push(1);
        topic.push(3);
        topic.push(2);
        System.out.println(topic.min());
    }

    public void push(int node) {
        stack.add(node);
        if (helper.isEmpty() || helper.peek() > node) {
            helper.add(node);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return helper.peek();
    }

    public int min() {
        return helper.peek();
    }
}
