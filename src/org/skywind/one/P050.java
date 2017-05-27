package org.skywind.one;

import org.skywind.util.Primes;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * <p>
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * <p>
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 * <p>
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 28/05/2017.
 */
public class P050 {

    private static final Primes __primes = new Primes();

    public static void main(String[] args) {
        int maxPrime = 0, maxTerms = 0;

        int[] primes = __primes.toStream().toArray();
        for (int i = 2; i < primes.length; i++) {
            int terms = findMaxTerms(primes[i], primes, i);
            if (terms >= maxTerms) {
                maxPrime = primes[i];
                maxTerms = terms;
            }
        }
        System.out.println(maxPrime);
    }

    private static int findMaxTerms(int prime, int[] primes, int limit) {
        for (int i = 0; i < limit; i++) {
            int sum = 0;

            int idx = i;
            int length = 0;
            while (sum < prime) {
                sum += primes[idx++];
                length++;
            }
            if (sum == prime) {
                return length;
            }
        }
        return -1;
    }
}
