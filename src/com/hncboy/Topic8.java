package com.hncboy;

/**
 * @author hncboy
 * @date 2019/7/12 10:18
 * @description 跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Topic8 {

    private int jumpFloor(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target == 0 ? 0 : (target == 1 ? 1 : 2);
        }
        int jump1 = 2;
        int jump2 = 1;
        while (target-- > 2) {
            jump1 += jump2;
            jump2 = jump1 - jump2;
        }
        return jump1;
    }

    public static void main(String[] args) {
        System.out.println(new Topic8().jumpFloor(10));
    }
}
