package org.skywind.one;

import org.skywind.util.Digits;

import java.math.BigInteger;

/**
 * A googol (10^100) is a massive number: one followed by one-hundred zeros;
 * 100^100 is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 * <p>
 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 01/06/2017.
 */
public class P056 {

    public static void main(String[] args) {
        int max = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 0; b < 100; b++) {
                BigInteger n = new BigInteger(String.valueOf(a)).pow(b);
                max = Math.max(max, Digits.getDigits(n).sum());
            }
        }
        System.out.println(max);
    }
}
