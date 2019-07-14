/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/14
 * Time: 20:29
 * <p>
 * 题目：反转链表
 * 题目描述：
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    private ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode reverseHead = ReverseList(head.next);
        temp.next = head;
        head.next = null;
        return reverseHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
