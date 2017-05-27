package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.Primes;

import java.util.List;
import java.util.stream.IntStream;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330,
 * is unusual in two ways: (i) each of the three terms are prime, and, (ii)
 * each of the 4-digit numbers are permutations of one another.
 * <p>
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property,
 * but there is one other 4-digit increasing sequence.
 * <p>
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 28/05/2017.
 */
public class P049 {

    private static final Primes primes = new Primes();

    public static void main(String[] args) {
        IntStream.range(1000, 9999).filter(P049::check).forEach(P049::print);
    }

    private static void print(int n) {
        System.out.println(n + "" + (n + 3330) + "" + (n + 6660));
    }

    private static boolean check(int n1) {
        int n2 = n1 + 3330;
        int n3 = n2 + 3330;
        if (primes.isPrime(n1) && primes.isPrime(n2) && primes.isPrime(n3)) {
            List<Integer> d1 = Digits.getDigits(n1);
            List<Integer> d2 = Digits.getDigits(n2);
            List<Integer> d3 = Digits.getDigits(n3);
            d1.removeAll(d2);
            d3.removeAll(d2);
            if (d1.isEmpty() && d3.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
