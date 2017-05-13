package org.skywind.one;

import org.skywind.util.Primes;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class P007 {

    public static void main(String[] args) {
        Primes primes = new Primes(1_000_000);
        primes.toStream().skip(10_000).findFirst().ifPresent(System.out::println);
    }
}
