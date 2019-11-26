package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/26 15:11
 * @description 左旋转字符串
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Topic43 {

    public static void main(String[] args) {
        System.out.println(new Topic43().leftRotateString("abcXYZdef", 3));
        System.out.println(new Topic43().leftRotateString("", 6));
    }

    private String leftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        n = n % str.length();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
