package org.skywind.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * Based on Sieve of Eratosthenes
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 12.05.17.
 */
public class Primes {

    private static final Primes _instance = new Primes();

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

    private Primes(BitSet bs, int size) {
        bitSet = bs;
        n = size;
    }

    public boolean isPrime(int n) {
        if (this.n <= n) throw new IllegalArgumentException("n is too big: " + n);
        return n > 1 && !bitSet.get(n);
    }

    public boolean isComposite(int n) {
        if (this.n <= n) throw new IllegalArgumentException("n is too big: " + n);
        return n > 1 && bitSet.get(n);
    }

    public IntStream toStream() {
        return IntStream.range(2, n).filter(this::isPrime);
    }

    public IntStream reverseStream() {
        return IntStream.iterate(n, x -> x - 1).limit(n - 1).filter(this::isPrime);
    }

    public IntStream toCompositeStream() {
        return IntStream.range(2, n).filter(this::isComposite);
    }

    public static Primes getBillionPrimes() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("/Users/sergey/primes"));
            return new Primes(BitSet.valueOf(bytes), 1_000_000_000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isLongPrime(long n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isLongComposite(long n) {
        if (n < 1_000_000) {
            return _instance.isComposite((int) n);
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) return true;
        }
        return false;
    }
}
