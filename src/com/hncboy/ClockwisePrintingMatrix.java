package com.hncboy;

import java.util.ArrayList;

/**
 * @author hncboy
 * @date 2019/10/9 12:48
 * @description 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockwisePrintingMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] matrix2 = new int[][]{{1}, {2}, {3}, {4}, {5}};
        System.out.println(new ClockwisePrintingMatrix().printMatrix(matrix1));
        System.out.println(new ClockwisePrintingMatrix().printMatrix(new int[][]{{1}}));
        System.out.println(new ClockwisePrintingMatrix().printMatrix(matrix2));
    }

    private ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        // 矩阵行数
        int row = matrix.length;
        // 矩阵列数
        int column = matrix[0].length;

        // 统计矩阵的层数
        int count = (Math.min(row, column) + 1) / 2;
        // 从外向内按层遍历
        for (int i = 0; i < count; i++) {
            // 最上边从左到右遍历
            for (int j = i; j < column - i; j++) {
                list.add(matrix[i][j]);
            }
            // 最右边从上到下遍历
            for (int j = i + 1; j < row - i; j++) {
                list.add(matrix[j][(column - 1) - i]);
            }
            // 最下边从右往左遍历，如果这一层只有一行则不用打印
            for (int j = (column - 1) - (i + 1); j >= i && (row - 1 - i != i); j--) {
                list.add(matrix[(row - 1) - i][j]);
            }
            // 最左边从下往上遍历，如果这一层只有一列则不用打印
            for (int j = (row - 1) - (i + 1); j >= i + 1 && (column - 1 - i) != i; j--) {
                list.add(matrix[j][i]);
            }
        }
        return list;
    }
}
