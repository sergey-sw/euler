package org.skywind.one;

import org.skywind.util.Primes;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class P010 {

    public static void main(String[] args) {
        Primes primes = new Primes(2_000_000);

        final long[] sum = {0};
        primes.toStream().forEach(x -> sum[0] += x);
        System.out.println(sum[0]);
    }
}
