package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/27 19:27
 * @description 二维数组中的查找
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Topic1 {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3}, {3, 4, 5}};
        System.out.println(new Topic1().find(4, array));
    }

    private boolean find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
