package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/18 19:35
 * @description 二进制中1的个数
 *
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Topic11 {

    public static void main(String[] args) {
        System.out.println(new Topic11().numberOf1(10));
    }

    private int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
