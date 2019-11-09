import java.util.ArrayList;

/**
 * @author hncboy
 * @date 2019/11/9 9:25
 * @description 从尾到头打印链表
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintTheLinkedListFromEndToEnd {

    private ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        PrintTheLinkedListFromEndToEnd p = new PrintTheLinkedListFromEndToEnd();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(p.printListFromTailToHead1(node));
        System.out.println(p.printListFromTailToHead2(node));
    }

    private ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    /**
     * 递归
     *
     * @param listNode
     * @return
     */
    private ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }


    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
