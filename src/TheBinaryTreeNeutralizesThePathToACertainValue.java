import java.util.ArrayList;

/**
 * @author hncboy
 * @date 2019/11/6 12:28
 * @description 二叉树中和为某一值的路径
 */
public class TheBinaryTreeNeutralizesThePathToACertainValue {

    public static void main(String[] args) {
        TheBinaryTreeNeutralizesThePathToACertainValue t = new TheBinaryTreeNeutralizesThePathToACertainValue();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(2);
        node.right.right = new TreeNode(5);
        System.out.println(t.findPath(node, 7));
    }

    private ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backTrace(root, target, result, new ArrayList<>());
        return result;
    }

    private void backTrace(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sub) {
        if (root == null) {
            return;
        }
        sub.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(sub));
        }
        backTrace(root.left, target, result, sub);
        backTrace(root.right, target, result, sub);
        sub.remove(sub.size() - 1);
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;

        }
    }
}
