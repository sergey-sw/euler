package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.Primes;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 26/05/2017.
 */
public class P041 {

    public static void main(String[] args) {
        new Primes(10_000_000).toStream()
                .filter(Digits::isPandigital)
                .peek(System.out::println)
                .max()
                .ifPresent(max -> System.out.println("max: " + max));
    }
}
