package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/18 18:08
 * @description 第一个只出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class TheFirstCharacterThatAppearsOnlyOnce {

    public static void main(String[] args) {
        TheFirstCharacterThatAppearsOnlyOnce t = new TheFirstCharacterThatAppearsOnlyOnce();
        System.out.println(t.firstNotRepeatingChar("ababc"));
        System.out.println(t.firstNotRepeatingChar("adbaca"));
    }

    private int firstNotRepeatingChar(String str) {
        int[] words = new int[58];

        for (int i = 0; i < str.length(); i++) {
            words[str.charAt(i) - 65] += 1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (words[str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }
}
