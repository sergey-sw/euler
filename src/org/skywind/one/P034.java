package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.Factorial;

import java.math.BigInteger;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * <p>
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * <p>
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 23.05.17.
 */
public class P034 {

    public static void main(String[] args) {
        for (long number = 10; number < 10_000_000; number++) {
            BigInteger sumOfDigitFactorials = Digits.getDigits(number).stream()
                    .map(Factorial::get)
                    .reduce(BigInteger.ZERO, BigInteger::add);

            if (number == sumOfDigitFactorials.longValue()) {
                System.out.println(number);
            }
        }
    }
}
