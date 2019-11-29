package com.hncboy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/11/29 14:38
 * @description 把二叉树打印成多行
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Topic60 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new Topic60().print2(root));
    }

    /**
     * 迭代
     *
     * @param pRoot
     * @return
     */
    private ArrayList<ArrayList<Integer>> print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            // 改层的节点数量
            int levelCount = queue.size();
            ArrayList<Integer> sub = new ArrayList<>();
            // 将该层的所有节点都添加进结合中
            while (levelCount > 0) {
                TreeNode node = queue.poll();
                sub.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelCount--;
            }
            result.add(sub);
        }
        return result;
    }

    /**
     * 递归
     *
     * @param pRoot
     * @return
     */
    private ArrayList<ArrayList<Integer>> print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        depth(pRoot, 1, result);
        return result;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        // 层次 +1
        if (depth > result.size()) {
            result.add(new ArrayList<>());
        }
        // 将值添加到对应的层次
        result.get(depth - 1).add(root.val);
        depth(root.left, depth + 1, result);
        depth(root.right, depth + 1, result);
    }

    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
