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
        System.out.println(new Primes(2_000_000).toStream().mapToLong(x -> x).sum());
    }
}
