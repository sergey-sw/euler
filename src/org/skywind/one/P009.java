package org.skywind.one;

import org.skywind.util.TimedCall;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class P009 {

    public static void main(String[] args) {
        System.out.println("a*b*c=" + TimedCall.call(P009::usingBruteForce));
    }

    private static long usingBruteForce() {
        for (int a = 1; a < 500; a++) {
            for (int b = 1; b < 500; b++) {
                for (int c = 1; c < 500 && a + b + c <= 1000; c++) {
                    if (a + b + c == 1000 && a * a + b * b == c * c) {
                        return a * b * c;
                    }
                }
            }
        }
        throw new IllegalStateException("Not found");
    }
}
