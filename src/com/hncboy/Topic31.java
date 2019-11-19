package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/11 14:32
 * @description 整数中1出现的次数（从1到n整数中1出现的次数）
 * <p>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化, 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Topic31 {

    public static void main(String[] args) {
        Topic31 topic = new Topic31();
        System.out.println(topic.numberOf1Between1AndN(1410065408));
        System.out.println(topic.numberOf1Between1AndN(10));
        System.out.println(topic.numberOf1Between1AndN(1));
    }

    private int numberOf1Between1AndN(int n) {
        long count = 0;
        // 分别计算个位、十位、百位上...出现 1 的个数
        for (long i = 1; i <= n; i *= 10) {
            // 高位
            long a = n / i;
            // 低位
            long b = n % i;
            /*
             当该位上的数属于 [2,9]，直接进 8 位将 a/10 的值 + 1，因为需要考虑该位为 1 的情况
             当该位上的数为 1，进 8 位之后也不会将总数 +1，该位为 1 的情况会移到下面的式子计算
             当改为上的数为 0，不用考虑该位为 1 的情况
             */
            count += (a + 8) / 10 * i;
            count += a % 10 == 1 ? b + 1 : 0;
        }
        return (int) count;
    }
}
