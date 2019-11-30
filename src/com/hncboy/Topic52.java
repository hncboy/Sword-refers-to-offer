package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 18:55
 * @description 正则表达式匹配
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Topic52 {

    public static void main(String[] args) {
        Topic52 topic = new Topic52();
        System.out.println(topic.match(new char[]{'a', 'a'}, new char[]{'a', 'a', '*'}));
        System.out.println(topic.match(new char[]{'a', 'a'}, new char[]{'a', 'b', '*'}));
        System.out.println(topic.match(new char[]{'a'}, new char[]{'a', '.'}));
    }

    private boolean match(char[] str, char[] pattern) {
        StringBuilder s = new StringBuilder();
        for (char ch : str) {
            s.append(ch);
        }
        StringBuilder p = new StringBuilder();
        for (char ch : pattern) {
            p.append(ch);
        }
        return match(s.toString(), p.toString());
    }

    /**
     * 递归
     *
     * @param s
     * @param p
     * @return
     */
    private boolean match(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return match(s, p.substring(2)) || (firstMatch && match(s.substring(1), p));
        } else {
            return firstMatch && match(s.substring(1), p.substring(1));
        }
    }

    /**
     * 动态规划 自底向上
     *
     * @param s
     * @param p
     * @return
     */
    private boolean match2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
