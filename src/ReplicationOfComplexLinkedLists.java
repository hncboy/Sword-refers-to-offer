import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/11/6 13:03
 * @description 复杂链表的复制
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ReplicationOfComplexLinkedLists {

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;

        System.out.println(clone(node1));
    }

    private static RandomListNode clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // 存放新旧节点的对应关系
        for (RandomListNode p = pHead; p != null; p = p.next) {
            map.put(p, new RandomListNode(p.label));
        }

        // 更新链表的 next 和 random 节点
        for (RandomListNode p = pHead; p != null; p = p.next) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
        }

        return map.get(pHead);
    }

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
