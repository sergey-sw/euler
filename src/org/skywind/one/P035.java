package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.Primes;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * <p>
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * <p>
 * How many circular primes are there below one million?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 23.05.17.
 */
public class P035 {

    private static final Primes primes = new Primes(1_000_000);

    public static void main(String[] args) {
        System.out.println(primes.toStream().filter(P035::allRotationsArePrime).count());
    }

    private static boolean allRotationsArePrime(int prime) {
        return Digits.getRotations(prime).stream().allMatch(primes::isPrime);
    }
}
