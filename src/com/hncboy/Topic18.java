package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/13 10:17
 * @description 二叉树的镜像
 *
 * 作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Topic18 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
        node.left.left = new TreeNode(6);
        node.left.left.left = new TreeNode(5);
        node.left.left.left.left = new TreeNode(4);
        new Topic18().mirror(node);
    }

    private void mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
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
