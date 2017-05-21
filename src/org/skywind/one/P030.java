package org.skywind.one;

import org.skywind.util.ExtMath;

import java.util.stream.IntStream;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 21/05/2017.
 */
public class P030 {

    public static void main(String[] args) {
        int max4 = (int) (ExtMath.pow(9, 4) * 4);
        System.out.println(IntStream.range(2, max4).filter(x -> match(x, 4)).sum());

        int max5 = (int) (ExtMath.pow(9, 5) * 5);
        System.out.println(IntStream.range(2, max5).filter(x -> match(x, 5)).sum());
    }

    private static boolean match(int n, int power) {
        long sum = 0;
        int num = n;
        while (n != 0) {
            sum += ExtMath.pow(n % 10, power);
            n = n / 10;
        }
        return sum == num;
    }
}
