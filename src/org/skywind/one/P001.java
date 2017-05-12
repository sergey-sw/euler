package org.skywind.one;

import java.util.stream.IntStream;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 12.05.17.
 */
public class P001 {

    public static void main(String[] args) {
        System.out.println(calc(new int[] {3, 5}, 10));
        System.out.println(calc(new int[] {3, 5}, 1000));
    }

    private static int calc(int[] base, int max) {
        return IntStream.range(0, max).filter(value -> {
            for (int divisor : base) {
                if (value % divisor == 0) return true;
            }
            return false;
        }).sum();
    }
}