package org.skywind.one;

import org.skywind.util.Primes;

/**
 * By replacing the 1st digit of the 2-digit number *3,
 * it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 * <p>
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is
 * the first example having seven primes among the ten generated numbers, yielding the family:
 * 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 * <p>
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 28/05/2017.
 */
public class P051 {

    private static final Primes primes = new Primes();
    private static final int target = 8;

    public static void main(String[] args) {
        int[] primes6 = primes.toStream().filter(prime -> prime > 100_000).toArray();

        for (int prime : primes6) {
            if (findFamily(prime)) {
                return;
            }
        }
    }

    private static boolean findFamily(int prime) {
        String str = String.valueOf(prime);
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    if (checkMask(str.toCharArray(), i, j, k) == target) {
                        printMask(str.toCharArray(), i, j, k);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int checkMask(char[] s, int pos1, int pos2, int pos3) {
        int size = 0;
        for (int digit = pos1 > 0 ? 0 : 1; digit < 10; digit++) {
            char c = Character.forDigit(digit, 10);
            s[pos1] = c;
            s[pos2] = c;
            s[pos3] = c;
            int num = Integer.valueOf(new String(s));
            if (primes.isPrime(num)) size++;
        }
        return size;
    }

    private static void printMask(char[] s, int pos1, int pos2, int pos3) {
        for (int digit = pos1 > 0 ? 0 : 1; digit < 10; digit++) {
            char c = Character.forDigit(digit, 10);
            s[pos1] = c;
            s[pos2] = c;
            s[pos3] = c;
            int num = Integer.valueOf(new String(s));
            if (primes.isPrime(num)) {
                System.out.println(num);
            }
        }
    }
}
