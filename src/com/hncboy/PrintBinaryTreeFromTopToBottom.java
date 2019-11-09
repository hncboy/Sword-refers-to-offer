package com.hncboy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/10/28 14:15
 * @description 从上往下打印二叉树
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTreeFromTopToBottom {

    public static void main(String[] args) {
        PrintBinaryTreeFromTopToBottom p = new PrintBinaryTreeFromTopToBottom();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right= new TreeNode(7);

        System.out.println(p.printFromTopToBottom(node));
    }

    private ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                result.add(node.left.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                result.add(node.right.val);
            }
        }
        return result;
    }


    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        private TreeNode(int val) {
            this.val = val;
        }
    }
}
