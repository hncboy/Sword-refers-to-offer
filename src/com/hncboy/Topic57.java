package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 19:59
 * @description 二叉树的下一个结点
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Topic57 {

    private TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 中序遍历：左父右
        // 1.如果该节点有右节点，那么第二个为右子树的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 2.如果该节点没有右节点：两种情况一样
        // 2.1 该节点为父节点的左节点：下个节点为父节点，也就是当前节点是其父节点的左节点
        // 2.2 该节点为父节点的右节点：从当前节点找父节点，直到当前节点是其父节点的左节点
        // 因为中序遍历左父右，找到当前节点是父节点的左节点的那个节点，而 pNode 刚好是那个节点的最右节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }

        // 3.最后一个节点
        return null;
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
