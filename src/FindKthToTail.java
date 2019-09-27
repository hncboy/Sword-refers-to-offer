/**
 * @author hncboy
 * @date 2019/9/27 14:10
 * @description 链表中倒数第k个结点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new FindKthToTail().findKthToTail(node, 2));
    }

    private ListNode findKthToTail(ListNode head, int k) {
        // 计算有多少个节点
        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }

        if (k > length) {
            return null;
        }

        // 查询第 length - k 个节点
        ListNode q = head;
        for (int i = 0; i < length - k; i++) {
            q = q.next;
        }
        return q;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
