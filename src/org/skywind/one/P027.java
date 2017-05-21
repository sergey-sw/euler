package org.skywind.one;

import org.skywind.util.Primes;

/**
 * Euler discovered the remarkable quadratic formula:
 *
 * n^2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39.
 * However, when n=40, 40^2+40+41=40(40+1)+41 is divisible by 41, and certainly when
 * n=41,41^2+41+41 is clearly divisible by 41.
 *
 * The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79.
 * The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form: n^2+an+b,
 * where |a|<1000 and |b|≤1000
 * where |n| is the modulus/absolute value of n, e.g. |11|=11 and |−4|=4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression that produces
 * the maximum number of primes for consecutive values of n, starting with n=0.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 21/05/2017.
 */
public class P027 {

    public static void main(String[] args) {
        Primes primes = new Primes(10_000_000);
        int max = 0;
        int ra = 0, rb = 0;

        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int length = 0;
                for (int n = 0; n < Integer.MAX_VALUE; n++) {
                    if (primes.isPrime(calc(a, b, n))) {
                        length++;
                    } else {
                        break;
                    }
                }
                if (max < length) {
                    max = length;
                    ra = a;
                    rb = b;
                }
            }
        }

        System.out.println(ra * rb);
    }

    private static int calc(int a, int b, int n) {
        return n * n + a * n + b;
    }
}
