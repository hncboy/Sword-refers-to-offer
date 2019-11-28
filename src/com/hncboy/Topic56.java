package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 19:31
 * @description 删除链表中重复的结点
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Topic56 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        System.out.println(new Topic56().deleteDuplication(head));
    }

    private ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
                prev.next = curr;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
