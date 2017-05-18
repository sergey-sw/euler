package org.skywind.util;

import java.math.BigInteger;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/05/2017.
 */
public class Factorial {

    public static BigInteger get(int n) {
        BigInteger f = new BigInteger("1");
        for (int i = 0; i < n; i++) {
            f = f.multiply(new BigInteger(String.valueOf(n - i)));
        }
        return f;
    }
}
