package org.skywind.one;

import org.skywind.util.Digits;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * It can be seen that the number, 125874, and its double, 251748,
 * contain exactly the same digits, but in a different order.
 * <p>
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 29/05/2017.
 */
public class P052 {

    public static void main(String[] args) {
        IntStream.range(10, 100_000_000).filter(P052::check).findFirst().ifPresent(System.out::println);
    }

    private static boolean check(int n) {
        List<Integer> digits = Digits.getDigits(n);
        Collections.sort(digits);
        for (int i = 2; i < 7; i++) {
            int x = n * i;
            List<Integer> x_digits = Digits.getDigits(x);
            Collections.sort(x_digits);

            if (!digits.equals(x_digits)) {
                return false;
            }
        }
        return true;
    }
}
