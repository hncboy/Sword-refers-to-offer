package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/26 15:24
 * @description 翻转单词顺序列
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Topic44 {

    public static void main(String[] args) {
        System.out.println(new Topic44().reverseSentence("student. a am I"));
        System.out.println(new Topic44().reverseSentence("I am a student."));
    }

    private String reverseSentence(String str) {
        char[] chars = str.toCharArray();
        // 翻转整个句子
        reverse(chars, 0, chars.length - 1);

        // 空格的位置
        int blank = 0;
        // 遍历句子中的每个单词，依次翻转
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, blank, i - 1);
                blank = i + 1;
            }
        }

        // 最后一个单词单独翻转
        reverse(chars, blank, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
