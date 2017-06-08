package org.skywind.util;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class ExtMath {

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }

    public static long pow(int number, int power) {
        long result = 1L;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        return result;
    }

    public static BigInteger powToBigInt(Integer number, int power) {
        BigInteger bi = new BigInteger(Integer.toString(number));
        return bi.pow(power);
    }

    public static int sqr(int n) {
        if (n > 40_000) throw new IllegalArgumentException("N is too big for integer square");
        return n * n;
    }

    public static int lcm(int... values) {
        return Arrays.stream(values).reduce(1, (a, b) -> Math.abs(a * b) / gcd(a, b));
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
