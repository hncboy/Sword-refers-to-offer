package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/27 15:05
 * @description 求1+2+3+...+n
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Topic47 {

    public static void main(String[] args) {
        System.out.println(new Topic47().sum(100));
    }

    private int sum(int n) {
        int sum = n;
        boolean result =(n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }
}
