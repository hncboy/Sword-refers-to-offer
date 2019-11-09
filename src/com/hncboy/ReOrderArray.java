package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/8 11:42
 * @description 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{1,3,5,7,2,4,6};
        new ReOrderArray().reOrderArray(array1);
        new ReOrderArray().reOrderArray(array2);
    }

    private void reOrderArray(int[] array) {
        // 空间换时间

        // 偶数的数量
        int evenCount = 0;
        int length = array.length;
        // 存放偶数的数组
        int[] evenArray = new int[length];

        for (int i = 0; i < length; i++) {
            if ((array[i] & 1) != 0) {
                array[i - evenCount] = array[i];
            } else {
                evenArray[evenCount] = array[i];
                evenCount++;
            }
        }

        for (int i = length - evenCount; i < length; i++) {
            array[i] = evenArray[i - length + evenCount];
        }
    }
}
