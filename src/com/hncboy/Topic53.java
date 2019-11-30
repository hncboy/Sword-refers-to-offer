package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 18:55
 * @description 表示数值的字符串
 */
public class Topic53 {

    private int index = 0;

    public static void main(String[] args) {
        Topic53 topic = new Topic53();
        System.out.println(topic.isNumeric2(new char[]{'+', '1', '0', '0'}));
        topic.index = 0;
        System.out.println(topic.isNumeric2(new char[]{'5', 'e', '2'}));
        topic.index = 0;
        System.out.println(topic.isNumeric2(new char[]{'1', '2', 'e'}));
        topic.index = 0;
        System.out.println(topic.isNumeric2(new char[]{'6', '.'}));
    }

    /**
     * 正则表示式
     *
     * @param str
     * @return
     */
    private boolean isNumeric1(char[] str) {
        // 能通过但有问题
        // [+\\-]?    匹配正号和负号（0或1个），-需要斜杠转义
        // \\d*         匹配整数部分（0或多个），如-.66，-6.66 都符合
        // (\\.\\d+)?   匹配一起出现的小数点和数字（0或1个），小数点后的数字1个或多个
        // ([eE][+\\-]?\\d+)? 指数部分（0或1个），[eE]肯定出现，+或-可以不出现，后面跟着的数字必须出现
        return String.valueOf(str).matches("[+\\-]?\\d*(\\.\\d+)?([eE][+\\-]?\\d+)?");
    }

    private boolean isNumeric2(char[] str) {
        if (str.length < 1) {
            return false;
        }

        boolean flag = scanInteger(str);

        // 除去小数点
        if (index < str.length && str[index] == '.') {
            index++;
            // 判断小数点后是否有整数，利用短路特性，先判断小数点后是否有整数
            // 小数点前后任意有整数即可，如 .6 表示 0.6，6. 表示 6.0
            flag = scanUnsignedInteger(str) || flag;
        }

        // 除去 E 或 e
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            // 判断 E 或 e 后是否符合正整数或负整数
            flag = flag && scanInteger(str);
        }

        // flag 为 true 且每个字符都判断过
        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        // 除去正号或负号
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        // 将整数的部分除去
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        // 如果不存在整数，则返回 false
        return start < index;
    }
}
