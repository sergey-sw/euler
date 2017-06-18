package org.skywind.one;

import org.skywind.util.Permutations;
import org.skywind.util.Primes;

/**
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of
 * positive numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8,
 * are all less than nine and relatively prime to nine, φ(9)=6.
 * The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.
 * <p>
 * Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.
 * <p>
 * Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/06/2017.
 */
public class P070 {

    public static void main(String[] args) {
        int LIMIT = 10_000_000;
        int FIRST_PRIME = 1009;

        int[] primesToCheck = new Primes().toStream().takeWhile(x -> x < LIMIT / FIRST_PRIME).toArray();

        int minN = 0;
        double minR = Double.MAX_VALUE;

        for (int i = 1; i < primesToCheck.length; i++) {
            for (int j = 0; j < i; j++) {
                int mult = primesToCheck[i] * primesToCheck[j];
                if (mult >= LIMIT) break;

                int t = (primesToCheck[i] - 1) * (primesToCheck[j] - 1);
                double r = 1.0 * mult / t;

                if (r < minR && Permutations.isPermutation(mult, t)) {
                    minR = r;
                    minN = mult;
                }
            }
        }

        System.out.println(minN);
    }
}
