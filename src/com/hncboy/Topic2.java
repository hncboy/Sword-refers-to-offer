package com.hncboy;

/**
 * @author hncboy
 * @date 2019/7/27 20:17
 * @description 替换空格
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Topic2 {

    /**
     * 直接调用函数，有点low
     * @param str
     * @return
     */
    private static String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("* * *");
        System.out.println(replaceSpace(stringBuffer));
    }
}
