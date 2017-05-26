package org.skywind.one;

import org.skywind.util.Digits;

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

    public static void main(String[] args) {
        Set<Integer> products = new HashSet<>();
        for (int a = 1; a < 5000; a++) {
            for (int b = a; b < 5000; b++) {
                if (Digits.isPandigital9(a, b, a * b)) {
                    products.add(a * b);
                    System.out.println(a + " " + b + " " + a * b);
                }
            }
        }

        System.out.println(products.stream().mapToLong(Long::valueOf).sum());
    }
}
