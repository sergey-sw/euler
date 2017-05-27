package org.skywind.util;

import java.util.*;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class Factorization {

    private static Primes primes = new Primes(1_000_000);

    public static List<Integer> getFactors(int n) {
        return getFactors((long) n);
    }

    public static List<Integer> getFactors(long n) {
        if (n < 1) {
            throw new IllegalArgumentException("n can't be factorized: " + n);
        }
        if (n == 1) return Collections.singletonList(1);

        List<Integer> factors = new ArrayList<>();
        OptionalInt factor;
        do {
            factor = findFactor(n, primes);
            if (factor.isPresent()) {
                factors.add(factor.getAsInt());
                n /= factor.getAsInt();
                if (n == 1) break;
            } else {
                throw new IllegalArgumentException("Can't factorize " + n);
            }
        } while (true);

        return factors;
    }

    public static Set<Integer> getUniqueFactors(long n) {
        if (n < 1) {
            throw new IllegalArgumentException("n can't be factorized: " + n);
        }
        if (n == 1) return Collections.singleton(1);

        Set<Integer> factors = new HashSet<>();
        OptionalInt factor;
        do {
            factor = findFactor(n, primes);
            if (factor.isPresent()) {
                factors.add(factor.getAsInt());
                n /= factor.getAsInt();
                if (n == 1) break;
            } else {
                throw new IllegalArgumentException("Can't factorize " + n);
            }
        } while (true);

        return factors;
    }

    private static OptionalInt findFactor(long n, Primes primes) {
        return primes.toStream().filter(prime -> n % prime == 0).findFirst();
    }
}
