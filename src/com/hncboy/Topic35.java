package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/18 18:39
 * @description 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入：1,2,3,4,5,6,7,0
 * 输出：7
 */
public class Topic35 {

    public static void main(String[] args) {
        Topic35 r = new Topic35();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(r.inversePairs(array));
    }

    private int inversePairs(int[] array) {
        return divideArray(array, 0, array.length - 1);
    }

    /**
     * 两两拆分数组
     *
     * @param array
     * @param start
     * @param end
     */
    private int divideArray(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int leftCount = divideArray(array, start, mid) % 1000000007;
        int rightCount = divideArray(array, mid + 1, end) % 1000000007;
        int count = mergeSort(array, start, mid, end);
        return (leftCount + rightCount + count) % 1000000007;
    }

    /**
     * 对区间内的数组进行统计逆序并归并排序
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private int mergeSort(int[] array, int start, int mid, int end) {
        // 存放 array 中 [start, end] 排序后的数组
        int[] sortedArray = new int[end - start + 1];
        // 分为两个有序区间 [start,mid] [mid+1,end]
        int i = start;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        // 将两个有序区间的前半部分排序存放进 sortedArray
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                sortedArray[k++] = array[i++];
            } else {
                sortedArray[k++] = array[j++];
                // 当 array[i] > array[j] 时，该对数字为逆序对
                // 因为是升序排序，所以前半部分有 mid-i+1 个比 array[i] 大的数，自然也比 array[j] 大
                count = (count + mid - i + 1) % 1000000007;
            }
        }
        // 在后半部分先依次插入小的有序区间
        while (i <= mid) {
            sortedArray[k++] = array[i++];
        }
        // 在后半部分再依次插入大的有序区间
        while (j <= end) {
            sortedArray[k++] = array[j++];
        }
        // 将排序后的数组再依次更新原始数组
        for (k = 0; k < sortedArray.length; k++) {
            array[start + k] = sortedArray[k];
        }
        return count;
    }
}
