package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 19:14
 * @description 链表中环的入口结点
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Topic55 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;
        System.out.println(new Topic55().entryNodeOfLoop(head));
    }

    private ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode low = pHead;
        ListNode fast = pHead;

        // 快慢指针找到环中的相遇点
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        // 慢指针指向头部
        low = pHead;
        // 快指针从相遇点出发，慢指针从头部出发，一定能相遇
        while (fast != low) {
            low = low.next;
            fast = fast.next;
        }
        return low;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
