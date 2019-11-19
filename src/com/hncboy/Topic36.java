package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/18 19:01
 * @description 两个链表的第一个公共结点
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Topic36 {

    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);
        pHead1.next.next.next = new ListNode(4);
        pHead1.next.next.next.next = new ListNode(5);

        ListNode pHead2 = new ListNode(7);
        pHead2.next = new ListNode(6);
        pHead2.next.next = pHead1.next;

        System.out.println(new Topic36().findFirstCommonNode(pHead1, pHead2));
    }

    private ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                // 当链表移动到尾部时，从另外一个链表头节点开始移动
                // 相当于除去长链表比短链表长的部分
                // 两条链表从该节点遍历到尾部的长度相等，一定会找到相同的节点
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
