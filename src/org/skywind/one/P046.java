package org.skywind.one;

import org.skywind.util.Primes;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 * <p>
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * <p>
 * It turns out that the conjecture was false.
 * <p>
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 27/05/2017.
 */
public class P046 {

    private static Primes primes = new Primes();
    private static int[] arr;
    private static int[] squares = IntStream.range(0, 1000).map(x -> x * x).toArray();

    public static void main(String[] args) {
        arr = primes.toStream().toArray();
        primes.toCompositeStream()
                .filter(x -> x % 2 == 1)
                .filter(P046::doesNotMatch)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static boolean doesNotMatch(int n) {
        for (int prime : arr) {
            int diff = n - prime;

            if (diff < 0) {
                return true;
            }

            if (Arrays.binarySearch(squares, diff / 2) > -1) {
                return false;
            }
        }
        return true;
    }
}
