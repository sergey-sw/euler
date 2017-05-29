package org.skywind.one;

import org.skywind.util.Combinatorics;

import java.math.BigInteger;

/**
 * There are exactly ten ways of selecting three from five, 12345:
 * <p>
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * <p>
 * In combinatorics, we use the notation, 5C3 = 10.
 * <p>
 * In general, nCr = n! / r! * (n−r)!
 * where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * <p>
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 29/05/2017.
 */
public class P053 {

    public static void main(String[] args) {
        BigInteger MILLION = BigInteger.TEN.pow(6);
        long cnt = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r < n; r++) {
                if (Combinatorics.getCombinations(n, r).compareTo(MILLION) > 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
