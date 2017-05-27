package org.skywind.one;

import org.skywind.util.Factorization;
import org.skywind.util.Primes;

import java.util.Set;

/**
 * The first two consecutive numbers to have two distinct prime factors are:
 * <p>
 * 14 = 2 × 7
 * 15 = 3 × 5
 * <p>
 * The first three consecutive numbers to have three distinct prime factors are:
 * <p>
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * <p>
 * Find the first four consecutive integers to have four distinct prime factors each.
 * What is the first of these numbers?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 27/05/2017.
 */
public class P047 {

    private static Primes primes = new Primes();

    public static void main(String[] args) {
        System.out.println(findFor(3));
        System.out.println(findFor(4));
    }

    private static int findFor(int goal) {
        int strike = 0;

        for (int i = 1; i < 1_000_000; i++) {
            if (match(i, goal)) {
                strike++;
                if (strike == goal) {
                    return i - goal + 1;
                }
            } else {
                strike = 0;
            }
        }
        return -1;
    }

    private static boolean match(int number, int size) {
        Set<Integer> factors = Factorization.getUniqueFactors((long) number);
        int cnt = 0;
        for (Integer factor : factors) {
            if (primes.isPrime(factor)) {
                cnt++;
            } else {
                return false;
            }
        }
        return cnt == size;
    }
}
