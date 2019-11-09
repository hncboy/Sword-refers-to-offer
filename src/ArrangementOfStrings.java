import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/8 14:35
 * @description 字符串的排列
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class ArrangementOfStrings {

    public static void main(String[] args) {
        System.out.println(new ArrangementOfStrings().permutation("aabb"));
    }

    /**
     * 字典序排列算法
     *
     * @param str
     * @return
     */
    private ArrayList<String> permutation(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        // 插入第一种情况
        result.add(String.valueOf(chars));
        int length = chars.length;

        while (true) {
            int left = length - 1;
            int right;

            // 从 left 位置往前找 chars[left-1] < chars[left] 的字符
            // 也就是从 left 位置往前找 前一个字符比后一个字符小的，记录小的那个字符下标为 left-1
            while (left >= 1 && chars[left - 1] >= chars[left]) {
                left--;
            }

            // 找到了头部结束循环
            if (left == 0) {
                break;
            }

            right = left;
            // right 从 left 位置开始找 chars[right] > chars[left-1] 的字符
            // 也就是 right 从 left 的位置开始找，找到最后一个大于 left-1 的字符，该字符的下标为 right-1
            while (right < length && chars[right] > chars[left - 1]) {
                right++;
            }

            // 交换 left-1 和 right-1 的值
            swap(chars, left - 1, right - 1);
            // 倒序 left 位置后的所有字符，使得 left 后所有字符最小的排列
            reverse(chars, left);
            // 得到下一个排序插入集合
            result.add(String.valueOf(chars));
        }

        return result;
    }

    /**
     * 反转 chars 数组中 k 位置后的所有字符
     *
     * @param chars
     * @param k
     */
    private void reverse(char[] chars, int k) {
        if (chars == null || chars.length <= k) {
            return;
        }

        int length = chars.length;
        for (int i = 0; i < (length - k) / 2; i++) {
            int m = k + i;
            int n = length - 1 - i;
            if (m <= n) {
                swap(chars, m, n);
            }
        }
    }

    /**
     * 交换 chars[i] 和 chars[j]
     *
     * @param chars
     * @param i
     * @param j
     */
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
