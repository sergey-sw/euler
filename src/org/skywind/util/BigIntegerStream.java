package org.skywind.util;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 15/06/2017.
 */
public class BigIntegerStream {

    public static Stream<BigInteger> range(long minInclusive, long maxExclusive) {
        return range(BigInteger.valueOf(minInclusive), BigInteger.valueOf(maxExclusive));
    }

    public static Stream<BigInteger> range(BigInteger minInclusive, BigInteger maxExclusive) {
        AtomicReference<BigInteger> next = new AtomicReference<>(minInclusive);
        return Stream.generate(() -> {
            BigInteger r = next.get();
            next.set(r.add(BigInteger.ONE));
            return r;
        }).takeWhile(x -> x.compareTo(maxExclusive) < 0);
    }
}
