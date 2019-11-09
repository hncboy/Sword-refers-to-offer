package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/7 17:28
 * @description 矩形覆盖
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectangularCover {

    public static void main(String[] args) {
        RectangularCover rc = new RectangularCover();
        System.out.println(rc.rectCover(4));
    }

    private int rectCover(int target) {
        return target <= 3 ? target : rectCover(target - 1) + rectCover(target - 2);
    }
}
