/**
 * @author hncboy
 * @date 2019/10/8 11:17
 * @description 数值的整数次方
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class NumericalIntegerPower {

    public static void main(String[] args) {
        System.out.println(new NumericalIntegerPower().power(2, 3));
        System.out.println(new NumericalIntegerPower().power(-2, 3));
        System.out.println(new NumericalIntegerPower().power(8, -3));
    }

    private double power(double base, int exponent) {
        double result = 1;
        // 折半计算
        /*for (int i = exponent; i != 0; i /= 2) {
            if (i % 2 != 0) {
                result *= base;
            }
            base *= base;
        }*/

        for (int i = Math.abs(exponent); i != 0; i >>= 1) {
            if ((i & 1) != 0) {
                result *= base;
            }
            base *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }
}
