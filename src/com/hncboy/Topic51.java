package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/28 18:42
 * @description 构建乘积数组
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class Topic51 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic51().multiply(new int[]{1, 2, 3, 4, 5})));
    }

    private int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int result = 1;

        // 遍历数组A，在B数组中存储自身位置左边的乘积
        for (int i = 0; i < A.length; i++) {
            B[i] = result;
            result *= A[i];
        }

        result = 1;
        // 遍历数组A，在B数组中存储自身位置右边的乘积
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] *= result;
            result *= A[i];
        }

        return B;
    }
}
