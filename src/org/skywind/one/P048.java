package org.skywind.one;

import java.math.BigInteger;

/**
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * <p>
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 27/05/2017.
 */
public class P048 {

    public static void main(String[] args) {
        System.out.println(usingBigInteger());
        System.out.println(usingLong());
    }

    private static String usingBigInteger() {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add(new BigInteger("" + i).pow(i));
        }
        BigInteger mod = sum.mod(new BigInteger("10000000000"));
        return mod.toString();
    }

    private static String usingLong() {
        long sum = 0;
        long ten = 10_000_000_000L;

        for (int i = 1; i <= 1000; i++) {
            long pow = 1;
            for (int j = 1; j <= i; j++) {
                pow = (pow * i) % ten;
            }
            sum = (sum + pow) % ten;
        }
        return String.valueOf(sum);
    }
}
