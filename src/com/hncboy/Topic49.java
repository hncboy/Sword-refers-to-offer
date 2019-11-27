package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/27 15:44
 * @description 把字符串转换成整数
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 */
public class Topic49 {

    public static void main(String[] args) {
        System.out.println(new Topic49().strToInt("+2147483647"));
        System.out.println(new Topic49().strToInt("    1a33"));
        System.out.println(new Topic49().strToInt("-2147483649"));
    }

    private int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        char firstChar = str.charAt(0);
        // 1 为正数，-1 为负数
        int symbol = 1;
        int i = 0;
        long result = 0;

        // 根据首字符判断该数的符号
        if (firstChar == '+') {
            i = 1;
        } else if (firstChar == '-') {
            i = 1;
            symbol = -1;
        }

        while (i < str.length()) {
            // 如果不是合法的数字，返回 0
            if (!Character.isDigit(str.charAt(i))) {
                return 0;
            }

            result = result * 10 + str.charAt(i) - '0';
            // 如果结果超出了 int 的长度，返回 0
            if (symbol == 1 && result > Integer.MAX_VALUE) {
                return 0;
            }
            if (symbol == -1 && result - 1 > Integer.MAX_VALUE) {
                return 0;
            }
            i++;
        }

        return (int) (result * symbol);
    }
}
