package org.skywind.one;

import org.skywind.util.Factorial;

import java.math.BigInteger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/05/2017.
 */
public class P020 {

    public static void main(String[] args) {
        BigInteger f10 = Factorial.get(10);
        System.out.println(f10);
        System.out.println(digitSum(f10));

        BigInteger f100 = Factorial.get(100);
        System.out.println(f100);
        System.out.println(digitSum(f100));
    }

    private static int digitSum(BigInteger n) {
        int sum = 0;
        BigInteger ten = new BigInteger("10");
        while (n.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] ints = n.divideAndRemainder(ten);
            n = ints[0];
            sum += ints[1].intValue();
        }
        return sum;
    }
}
