package org.skywind.one;

import org.skywind.util.CounterMap;
import org.skywind.util.ExtMath;
import org.skywind.util.Factorization;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * 2520 is the smallest number that can be divided by each
 * of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly
 * divisible by all of the numbers from 1 to 20?
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/12/17.
 */
public class P005 {

    private static final int MAX = 20;

    public static void main(String[] args) {
        System.out.println("Min: " + usingBruteForce());

        System.out.println("Min: " + usingFactorization());
    }

    private static long usingFactorization() {
        Map<Integer, Integer> factor2Power = new HashMap<>();
        for (int i = 11; i <= MAX; i++) {
            CounterMap<Integer> prime2occurrences = new CounterMap<>();

            Factorization.getFactors(i).forEach(prime2occurrences::inc);

            for (Map.Entry<Integer, Integer> e : prime2occurrences.getMap().entrySet()) {
                factor2Power.merge(e.getKey(), e.getValue(), Math::max);
            }
        }

        long result = 1;
        for (Map.Entry<Integer, Integer> e : factor2Power.entrySet()) {
            result *= ExtMath.pow(e.getKey(), e.getValue());
        }
        return result;
    }

    private static long usingBruteForce() {
        // find max possible number
        // it can't be greater than multiply of all elements
        long max = LongStream.rangeClosed(11, MAX).reduce(1, (x, y) -> x * y);

        // check every number until it can be divided by all elements
        main:
        for (long i = 1000; i < max; i++) {
            for (int j = 11; j <= MAX; j++) {
                if (i % j != 0) {
                    continue main;
                }
            }
            return i;
        }

        throw new IllegalStateException("not found");
    }
}
