package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.ExtMath;

import java.math.BigInteger;

/**
 * The 5-digit number, 16807=7^5, is also a fifth power.
 * Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
 * <p>
 * How many n-digit positive integers exist which are also an nth power?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 08/06/2017.
 */
public class P063 {

    public static void main(String[] args) {
        int cnt = 0;

        main:
        for (int i = 1; i < 100; i++) {
            for (int j = 1; true; j++) {
                BigInteger pow = ExtMath.powToBigInt(i, j);
                if (j == Digits.getNumberOfDigits(pow)) {
                    System.out.println(i + "^" + j + "=" + pow);
                    cnt++;
                } else {
                    continue main;
                }
            }
        }
        System.out.println(cnt);
    }
}
