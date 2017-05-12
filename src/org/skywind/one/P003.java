package org.skywind.one;

import org.skywind.util.Primes;

import java.util.OptionalInt;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 12.05.17.
 */
public class P003 {

    public static void main(String[] args) {
        long n = 600851475143L;
        Primes primes = new Primes((int) Math.sqrt(n));
        int maxFactor = 0;

        do {
            OptionalInt factor = findFactor(n, primes);
            if (factor.isPresent()) {
                System.out.println("Found factor: " + factor.getAsInt());
                n /= factor.getAsInt();
                maxFactor = Math.max(maxFactor, factor.getAsInt());
            } else {
                if (primes.isPrime((int) n)) {
                    System.out.println("Max factor: " + maxFactor);
                    return;
                } else {
                    throw new IllegalArgumentException("Can't factorize: " + n);
                }
            }
        } while (true);
    }

    private static OptionalInt findFactor(long n, Primes primes) {
        return primes.toStream().filter(prime -> n % prime == 0).findFirst();
    }
}
