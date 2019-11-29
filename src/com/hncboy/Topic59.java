package com.hncboy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/11/29 14:18
 * @description 按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Topic59 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new Topic59().print(root));
    }

    private ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        // 统计这一层的节点数
        while (!queue.isEmpty()) {
            // 该层的节点数量
            int levelCount = queue.size();
            ArrayList<Integer> sub = new ArrayList<>();

            while (levelCount > 0) {
                TreeNode node = queue.poll();
                // 根据层次来判断顺序
                if (result.size() % 2 == 0) {
                    sub.add(node.val);
                } else {
                    sub.add(0, node.val);
                }

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

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
