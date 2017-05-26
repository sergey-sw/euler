package org.skywind.util;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * Based on Sieve of Eratosthenes
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 12.05.17.
 */
public class Primes {

    // unset bits are prime numbers
    private final BitSet bitSet;
    private final int n;

    public Primes() {
        this(1_000_000);
    }

    public Primes(int size) {
        n = Math.max(size, 1_000_000);
        bitSet = new BitSet(size);

        for (int i = 2; i <= n / 2; i++) {
            if (!bitSet.get(i)) {
                for (int j = 2 * i; j <= n; j += i) {
                    bitSet.set(j);
                }
            }
        }
    }

    public boolean isPrime(int n) {
        return n > 1 && !bitSet.get(n);
    }

    public IntStream toStream() {
        return IntStream.range(2, n).filter(this::isPrime);
    }

    public IntStream reverseStream() {
        return IntStream.iterate(n, x -> x - 1).limit(n - 1).filter(this::isPrime);
    }
}
