package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/6 13:39
 * @description 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Topic26 {

    private TreeNode prev = null;

    public static void main(String[] args) {
        Topic26 b = new Topic26();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);
        System.out.println(b.convert(node));
    }

    private TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convert(pRootOfTree.right);
        if (prev == null) {
            prev = pRootOfTree;
        } else {
            pRootOfTree.right = prev;
            prev.left = pRootOfTree;
            prev = pRootOfTree;
        }
        convert(pRootOfTree.left);
        return prev;
    }

    /**
     * 中序遍历将节点放进数组
     * 再对数组进行操作
     *
     * @param pRootOfTree
     * @return
     */
    private TreeNode convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        inOrderTraversal(pRootOfTree, result);

        for (int i = 0; i < result.size() - 1; i++) {
            result.get(i).right = result.get(i + 1);
            result.get(i + 1).left = result.get(i);
        }

        return result.get(0);
    }

    /**
     * 中序遍历
     *
     * @param head
     * @param result
     */
    private void inOrderTraversal(TreeNode head, List<TreeNode> result) {
        if (head == null) {
            return;
        }
        inOrderTraversal(head.left, result);
        result.add(head);
        inOrderTraversal(head.right, result);
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
