package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/18 14:07
 * @description 丑数
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        System.out.println(u.getUglyNumber(7));
        System.out.println(u.getUglyNumber(8));
        System.out.println(u.getUglyNumber(9));
    }

    private int getUglyNumber(int index) {
        if (index < 7) {
            return index;
        }
        int[] result = new int[index];
        result[0] = 1;

        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; ++i) {
            result[i] = Math.min(result[t2] * 2, Math.min(result[t3] * 3, result[t5] * 5));
            if (result[i] == result[t2] * 2) {
                t2++;
            }
            if (result[i] == result[t3] * 3) {
                t3++;
            }
            if (result[i] == result[t5] * 5) {
                t5++;
            }
        }
        return result[index - 1];
    }
}
