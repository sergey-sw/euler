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

    public Primes(int bits) {
        bitSet = new BitSet(bits);
        n = bits;

        for (int i = 2; i < bits; i++) {
            if (!bitSet.get(i)) {
                for (int j = 2 * i; j < bits; j+= i) {
                    bitSet.set(j);
                }
            }
        }
    }

    public boolean isPrime(int n) {
        return !bitSet.get(n);
    }

    public IntStream toStream() {
        return IntStream.range(2, n).filter(this::isPrime);
    }

    public int[] toArray() {
        return toStream().toArray();
    }
}
