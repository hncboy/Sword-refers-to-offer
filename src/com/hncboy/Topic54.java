package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 18:57
 * @description 字符流中第一个不重复的字符
 */
public class Topic54 {

    private int[] hash = new int[256];
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Topic54 topic = new Topic54();
        topic.insert('g');
        topic.insert('o');
        System.out.println(topic.firstAppearingOnce());
        topic.insert('o');
        topic.insert('g');
        topic.insert('l');
        topic.insert('e');
        System.out.println(topic.firstAppearingOnce());
    }

    private void insert(char ch) {
        sb.append(ch);
        hash[ch]++;
    }

    private char firstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {
            if (hash[sb.charAt(i)] == 1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
