package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/11 17:48
 * @description 把数组排成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ArrangeTheArrayToTheSmallestNumber {

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 32, 321, 256, 109, 512};
        System.out.println(printMinNumber(numbers));
    }

    private static String printMinNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // 不断比较两两数字结合的大小
                int sum1 = Integer.parseInt(numbers[i] + "" + numbers[j]);
                int sum2 = Integer.parseInt(numbers[j] + "" + numbers[i]);
                if (sum1 > sum2) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }
}
