import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/8/29
 * Time: 17:30
 * <p>
 * 题目：重建二叉树
 * 题目描述：
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 栈：先进后出
 * 队列：先进先出
 */
public class QueueWithTwoStacks {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    private static void push(int node) {
        stack1.push(node);
    }

    private static int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
