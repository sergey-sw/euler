package org.skywind.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class Factorization {

    private static Primes primes = new Primes(1_000_000);

    public static List<Integer> getFactors(long n) {
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
        } while (factor.isPresent());

        return factors;
    }

    public static OptionalInt findFactor(long n, Primes primes) {
        return primes.toStream().filter(prime -> n % prime == 0).findFirst();
    }
}
