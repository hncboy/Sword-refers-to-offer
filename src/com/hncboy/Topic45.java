package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/27 13:10
 * @description 扑克牌顺子
 *
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,
 * 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class Topic45 {

    public static void main(String[] args) {
        System.out.println(new Topic45().isContinuous(new int[]{1, 3, 0, 0, 5}));
        System.out.println(new Topic45().isContinuous(new int[]{5, 2, 3, 1, 0}));
    }

    private boolean isContinuous(int[] numbers) {
        if (numbers.length == 0 || numbers.length > 5) {
            return false;
        }
        // 组成顺子的条件：
        // 1.除 0 以外没有包含重复的数
        // 2.max-min<5

        int min = 14;
        int max = 0;
        int flag = 0;
        for (int number : numbers) {
            if (number == 0) {
                continue;
            }
            // 条件一：使用 BitMap 排序判断有无重复的数字
            // 因为 1&1=1，如果 ((flag >> number) & 1) == 1，说明有重复的数字
            if (((flag >> number) & 1) == 1) {
                return false;
            }
            // 因为 0|1=1， 用此方法将 flag 的第 number 位置为 1
            flag |= (1 << number);

            max = Math.max(max, number);
            min = Math.min(min, number);
            // 条件二
            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }
}
