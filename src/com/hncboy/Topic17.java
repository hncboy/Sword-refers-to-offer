package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/9 12:04
 * @description 树的子结构
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Topic17 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        node1.left = new TreeNode(8);
        node1.right = new TreeNode(7);
        node1.left.left = new TreeNode(9);
        node1.left.right = new TreeNode(2);

        TreeNode node2 = new TreeNode(8);
        node2.left = new TreeNode(9);
        node2.right = new TreeNode(2);
        System.out.println(new Topic17().hasSubtree(node1, node2));
    }

    private boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                // 如果两个节点的值一样，则分别对左子树和右子树进行遍历
                result = isSubtree(root1, root2);
            }
            if (!result) {
                // 没有一样的则从节点的左子树出发遍历
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                // 没有一样的则从节点的又子树出发遍历
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        // 当 root1 遍历完，root2 还没遍历完，则 root2 不是 root1 的子树
        if (root1 == null && root2 != null) {
            return false;
        }
        // 当 root2 遍历完时，证明 root2 是 root1 的子树
        if (root2 == null) {
            return true;
        }
        // 当两个节点的值不一样时，停止遍历
        if (root1.val != root2.val) {
            return false;
        }
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
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
