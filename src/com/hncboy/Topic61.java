package com.hncboy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/29 14:51
 * @description 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class Topic61 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        //System.out.println(new Topic61().serialize(root));
        System.out.println(new Topic61().deserialize("1,2,4,null,null,5,null,null,3,6,null,null,7,null,null,"));
    }

    private String serialize(TreeNode root) {
        return serialize(root, "");
    }

    private String serialize(TreeNode root, String result) {
        if (root == null) {
            result += "null,";
        } else {
            // 前序遍历连接各个节点
            result += root.val + ",";
            result = serialize(root.left, result);
            result = serialize(root.right, result);
        }
        return result;
    }

    private TreeNode deserialize(String str) {
        // 将字符串用逗号分割放进链表
        return deserialize(new LinkedList<>(Arrays.asList(str.split(","))));
    }

    private TreeNode deserialize(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        // 将非空节点连接
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
