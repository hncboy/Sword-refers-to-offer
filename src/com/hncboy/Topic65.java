package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/30 16:26
 * @description 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Topic65 {

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str1 = {'b', 'c', 'c', 'e', 'd'};
        char[] str2 = {'a', 'b', 'c', 'b'};
        System.out.println(new Topic65().hasPath(matrix, 3, 4, str1));
        System.out.println(new Topic65().hasPath(matrix, 3, 4, str2));
    }

    private boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 标记该位置是否被访问
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTrack(matrix, visited, i, j, 0, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[] matrix, boolean[][] visited, int i, int j, int count, char[] target) {
        if (i >= 0 && i < visited.length && j >= 0 && j < visited[0].length) {
            if (!visited[i][j] && matrix[i * visited[0].length + j] == target[count]) {
                // 只要找到符合的字符串就返回 true‘
                if (count == target.length - 1) {
                    return true;
                }
                visited[i][j] = true;
                // 向四个方向遍历
                if (backTrack(matrix, visited, i, j - 1, count + 1, target)
                        || backTrack(matrix, visited, i, j + 1, count + 1, target)
                        || backTrack(matrix, visited, i - 1, j, count + 1, target)
                        || backTrack(matrix, visited, i + 1, j, count + 1, target)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }
}
