/**
 * @author hncboy
 * @date 2019/9/18 19:27
 * @description 变态跳台阶
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    public static void main(String[] args) {
        System.out.println(new JumpFloorII().JumpFloorII(3));
    }

    private int JumpFloorII(int target) {
        return target == 1 ? 1 : 2 * JumpFloorII(target - 1);
    }
}
