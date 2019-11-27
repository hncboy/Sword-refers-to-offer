package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/27 15:19
 * @description 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Topic48 {

    public static void main(String[] args) {
        System.out.println(new Topic48().add(2, 3));
    }

    private int add(int num1, int num2) {
        while (num2 != 0) {
            // 相加各位的值，不算进位
            int sum = num1 ^ num2;
            // 计算进位值，没有进位的话 num=2，结束循环
            num2 = (num1 & num2) << 1;
            // 将 sum 赋给num1，重复上面两步
            num1 = sum;
        }
        return num1;
    }
}
