package com.hncboy;

import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2019/11/27 14:01
 * @description 孩子们的游戏(圆圈中最后剩下的数)
 *
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,
 * 哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 */
public class Topic46 {

    public static void main(String[] args) {
        System.out.println(new Topic46().lastRemaining1(6, 7)); // 4
        System.out.println(new Topic46().lastRemaining1(5, 3)); // 4
    }

    private int lastRemaining2(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int curr = 0;
        while (list.size() > 1) {
            // 计算报到 m-1 的下标
            curr = (curr + m - 1) % list.size();
            list.remove(curr);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }


    private int lastRemaining1(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }

        int[] children = new int[n];
        for (int i = 0, count = n, curr = 0; count > 1; i = (i + 1) % n) {
            if (children[i] != -1) {
                // 报数报到 m-1
                if (curr == m - 1) {
                    // 该孩子所在位置置为 -1
                    children[i] = -1;
                    // 从 0 开始报数
                    curr = 0;
                    // 孩子数量 -1
                    count--;
                } else {
                    // 接着报数
                    children[i] = curr;
                    curr = (curr + 1) % m;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (children[j] != -1) {
                return j;
            }
        }
        return -1;
    }
}
