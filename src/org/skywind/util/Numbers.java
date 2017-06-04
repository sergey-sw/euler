package org.skywind.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.stream.LongStream;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 27/05/2017.
 */
public class Numbers {

    public static long[] triangles(int size) {
        return generateArr(size, Numbers::getTriangle);
    }

    public static long getTriangle(long n) {
        return n * (n + 1) / 2;
    }

    public static long[] pentagonals(int size) {
        return generateArr(size, Numbers::getPentagonal);
    }

    public static long getPentagonal(long n) {
        return n * (3 * n - 1) / 2;
    }

    public static long[] hexagonals(int size) {
        return generateArr(size, Numbers::getHexagonal);
    }

    public static long getHexagonal(long n) {
        return n * (2 * n - 1);
    }

    public static long[] squares(int size) {
        return generateArr(size, Numbers::getSquare);
    }

    public static long getSquare(long n) {
        return n * n;
    }

    public static long[] heptagonals(int size) {
        return generateArr(size, Numbers::getHeptagonal);
    }

    public static long getHeptagonal(long n) {
        return n * (5 * n - 3) / 2;
    }

    public static long[] octagonals(int size) {
        return generateArr(size, Numbers::getOctagonal);
    }

    public static long getOctagonal(long n) {
        return n * (3 * n - 2);
    }

    private static long[] generateArr(int size, IntToLongFunction func) {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = func.applyAsLong(i + 1);
            if (arr[i] < 0) {
                throw new IllegalArgumentException("num is negative: " + arr[i]);
            }
        }
        return arr;
    }

    public static int getOrder(int number) {
        if (number < 10) {
            return 10;
        } else if (number < 100) {
            return 100;
        } else if (number < 1000) {
            return 1000;
        } else if (number < 10_000) {
            return 10_000;
        } else {
            throw new IllegalArgumentException("number too big: " + number);
        }
    }

    public static LongStream generate(LongFunction<Long> generator) {
        final AtomicInteger idx = new AtomicInteger(1);
        return LongStream.generate(() -> generator.apply(idx.getAndIncrement()));
    }
}
