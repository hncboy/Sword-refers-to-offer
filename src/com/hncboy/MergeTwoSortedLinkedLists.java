package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/27 14:17
 * @description 合并两个排序的链表
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        System.out.println(new MergeTwoSortedLinkedLists().merge(list1, list2));

    }

    /**
     * 归并排序
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        // 如果一个链表为空，则直接返回另一个链表
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val > list2.val) {
            list2.next = merge(list1, list2.next);
            return list2;
        } else {
            list1.next = merge(list1.next, list2);
            return list1;
        }
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
