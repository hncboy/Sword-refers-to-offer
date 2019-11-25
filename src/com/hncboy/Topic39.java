package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/25 12:13
 * @description 平衡二叉树
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */
public class Topic39 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        System.out.println(new Topic39().isBalanced(root));
    }

    /**
     * 从底至顶（提前阻断法）
     *
     * @param root
     * @return
     */
    private boolean isBalanced2(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        // 自底向上遍历，如果子树是平衡二叉树，则返回子树的高度。
        // 如果子树不是平衡二叉树，返回 -1，停止遍历。
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 暴力法
     *
     * @param root
     * @return
     */
    private boolean isBalanced(TreeNode root) {
        // 比较每个节点左右子树的最大深度差是否大于1
        return root == null || Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取该节点最大深度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
