package com.hncboy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/11/25 11:51
 * @description 二叉树的深度
 * <p>
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Topic38 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        System.out.println(new Topic38().treeDepth2(root));
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    private int treeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 当前节点所在层数
        int depth = 0;
        // 下层的节点总数
        int nextCount = 1;
        // 已经遍历的节点数量
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            // count == nextCount 时，代表该层的节点已经遍历完毕
            if (++count == nextCount) {
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private int treeDepth(TreeNode root) {
        return root == null ? 0 : Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
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
