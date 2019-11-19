package com.hncboy;

/**
 * @author hncboy
 * @date 2019/7/12 9:29
 * @description 斐波那契数列
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 */
public class Topic7 {

    /**
     * 递归
     *
     * @param n 第几个
     * @return 结果
     */
    private int fibonacci1(int n) {
        return n == 0 ? 0 : (n == 1 ? 1 : fibonacci1(n - 1) + fibonacci1(n - 2));
    }

    /**
     * 迭代
     *
     * @param n 第几个
     * @return 结果
     */
    private int fibonacci2(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n == 0 ? 0 : 1;
        }
        int n1 = 1, n2 = 1;
        while (n-- > 2) {
            n1 += n2;
            n2 = n1 - n2;
        }
        return n1;
    }

    public static void main(String[] args) {
        Topic7 topic = new Topic7();
        long time1 = System.currentTimeMillis();
        System.out.println(topic.fibonacci1(40));
        long time2 = System.currentTimeMillis();
        System.out.println("递归耗时：" + (time2 - time1) + "ms");

        System.out.println(topic.fibonacci2(40));
        long time3 = System.currentTimeMillis();
        System.out.println("迭代耗时：" + (time3 - time2) + "ms");
    }
}

