/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/23
 * Time: 21:30
 * <p>
 * 题目：跳台阶
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {

    /**
     * 测试
     *
     * @param array
     * @return
     */
    private static int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 二分法
     * 来源：牛客网
     *
     * mid = low + (high - low)/2
     * 需要考虑三种情况：
     * (1)array[mid] > array[high]:
     * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
     * low = mid + 1
     * (2)array[mid] == array[high]:
     * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
     * 还是右边,这时只好一个一个试 ，
     * high = high - 1
     * (3)array[mid] < array[high]:
     * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
     * 边。因为右边必然都是递增的。
     * high = mid
     *
     * @param array
     * @return
     */
    private static int minNumberInRotateArray2(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray1(array));
        System.out.println(minNumberInRotateArray2(array));
    }
}
