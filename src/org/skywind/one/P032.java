package org.skywind.one;

import java.util.HashSet;
import java.util.Set;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand,
 * multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 23.05.17.
 */
public class P032 {

    private static int[] digits = new int[10];

    public static void main(String[] args) {
        Set<Integer> products = new HashSet<>();
        for (int a = 1; a < 5000; a++) {
            for (int b = a; b < 5000; b++) {
                if (isPandigital(a, b, a * b)) {
                    products.add(a * b);
                    System.out.println(a + " " + b + " " + a * b);
                }
            }
        }

        System.out.println(products.stream().mapToLong(Long::valueOf).sum());
    }

    private static boolean isPandigital(int a, int b, int c) {
        for (int i = 1; i < 10; i++) {
            digits[i] = 0;
        }
        if (notPandigital(a)) return false;
        if (notPandigital(b)) return false;
        if (notPandigital(c)) return false;

        for (int i = 1; i < 10; i++) {
            if (digits[i] == 0) return false;
        }
        return true;
    }

    private static boolean notPandigital(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digits[digit] == 0) {
                digits[digit] = 1;
                n = n / 10;
            } else {
                return true;
            }
        }
        return false;
    }
}
