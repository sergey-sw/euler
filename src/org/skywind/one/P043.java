package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.Permutations;

import java.util.List;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each
 * of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
 * <p>
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * <p>
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * <p>
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 26/05/2017.
 */
public class P043 {

    private static final int[] primes = new int[]{0, 2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {
        long sum = Permutations.allPermutations("1234567890".toCharArray())
                .stream()
                .filter(s -> s.charAt(0) != '0')
                .map(Long::valueOf)
                .filter(P043::match)
                .filter(Digits::isPandigital10)
                .peek(System.out::println)
                .reduce(0L, (x, y) -> x + y);
        System.out.println("sum: " + sum);
    }

    private static boolean match(long pandigital) {
        List<Integer> digits = Digits.getDigits(pandigital);
        for (int i = 1; i < 8; i++) {
            int number = digits.get(i) * 100 + digits.get(i + 1) * 10 + digits.get(i + 2);
            if (number % primes[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
