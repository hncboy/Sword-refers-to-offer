package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/30 17:01
 * @description 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Topic66 {

    public static void main(String[] args) {
        System.out.println(new Topic66().movingCount(5, 10, 10));
    }

    private int movingCount(int threshold, int rows, int cols) {
        return backTrack(new boolean[rows][cols], 0, 0, threshold);
    }

    private int backTrack(boolean[][] visited, int i, int j, int threshold) {
        if (i >= 0 && i < visited.length && j >= 0 && j < visited[0].length) {
            if (sum(i) + sum(j) <= threshold && !visited[i][j]) {
                visited[i][j] = true;
                // 向四个方向遍历
                return backTrack(visited, i, j - 1, threshold)
                        + backTrack(visited, i, j + 1, threshold)
                        + backTrack(visited, i - 1, j, threshold)
                        + backTrack(visited, i + 1, j, threshold) + 1;
            }
        }
        return 0;
    }

    /**
     * 计算位数之和
     *
     * @param num
     * @return
     */
    private int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
