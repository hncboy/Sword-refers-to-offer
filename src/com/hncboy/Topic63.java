package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/11/29 15:26
 * @description 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Topic63 {

    private int count = 0;

    /**
     * 小顶堆，存放元素大的一半，最小的元素在顶部
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /**
     * 大顶堆，存放元素小的一半，最大的元素在顶部
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) {
        Topic63 topic = new Topic63();
        topic.insert(1);
        topic.insert(5);
        topic.insert(4);
        topic.insert(2);
        topic.insert(3);
        System.out.println(topic.getMedian());
    }

    private void insert(Integer num) {
        // 奇数的话将新插入的数放入小顶堆，偶数的话放入大顶堆
        if (count % 2 == 0) {
            // 将新的数插入大顶堆，然后将大顶堆中最大的出弹出插入小顶堆
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            // 将新的数插入小顶堆，然后将小顶堆中最小的出弹出插入大顶堆
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        count++;
    }

    private Double getMedian() {
        if (count % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return (double) minHeap.peek();
        }
    }
}
