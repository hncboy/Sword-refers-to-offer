package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/29 15:07
 * @description 二叉搜索树的第k个结点
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class Topic62 {

    private int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(new Topic62().kthNode(root, 3));
    }

    private TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = kthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            if (++count == k) {
                return pRoot;
            }
            return kthNode(pRoot.right, k);
        }
        return null;
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
