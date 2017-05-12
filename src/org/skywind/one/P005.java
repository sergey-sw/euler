package org.skywind.one;

import org.skywind.util.Factorization;
import org.skywind.util.ExtMath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
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
            Map<Integer, List<Integer>> byPrime = Factorization.getFactors(i).stream().collect(Collectors.groupingBy(x -> x));
            Map<Integer, Integer> prime2MaxPower = byPrime.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));
            for (Map.Entry<Integer, Integer> e : prime2MaxPower.entrySet()) {
                if (factor2Power.containsKey(e.getKey())) {
                    if (factor2Power.get(e.getKey()) < e.getValue()) {
                        factor2Power.put(e.getKey(), e.getValue());
                    }
                } else {
                    factor2Power.put(e.getKey(), e.getValue());
                }
            }
        }

        long result = 1;
        for (Map.Entry<Integer, Integer> e : factor2Power.entrySet()) {
            result *= ExtMath.pow(e.getKey(), e.getValue());
        }
        return result;
    }

    private static long usingBruteForce() {
        long max = LongStream.rangeClosed(11, MAX).reduce(1, (x, y) -> x * y);

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
