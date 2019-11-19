package com.hncboy;

/**
 * @author hncboy
 * @date 2019/7/14 20:29
 * @description 反转链表
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Topic15 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new Topic15().reverseList(head));
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode reverseHead = reverseList(head.next);
        temp.next = head;
        head.next = null;
        return reverseHead;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}