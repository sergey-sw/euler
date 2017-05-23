package org.skywind.one;

import org.skywind.util.Primes;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove
 * digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 * <p>
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * <p>
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/05/2017.
 */
public class P037 {

    private static Primes primes = new Primes();

    public static void main(String[] args) {
        int sum = primes.toStream().filter(x -> x > 7).filter(P037::isTruncatable).peek(System.out::println).sum();
        System.out.println("sum: " + sum);
    }

    private static boolean isTruncatable(int prime) {
        int n = prime;
        while (n > 10) {
            n /= 10;
            if (!primes.isPrime(n)) return false;
        }

        int d = 10;
        while (d < prime) {
            if (!primes.isPrime(prime % d)) return false;
            d *= 10;
        }

        return true;
    }
}
