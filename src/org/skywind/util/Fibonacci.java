package org.skywind.util;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 19/05/2017.
 */
public class Fibonacci {

    public static Stream<BigInteger> getSequence() {
        final BigInteger[] prev = {BigInteger.ZERO};

        return Stream.iterate(BigInteger.ONE, curr -> {
            BigInteger next = prev[0].add(curr);
            prev[0] = curr;
            return next;
        });
    }
}
