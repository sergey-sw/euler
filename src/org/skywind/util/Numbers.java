package org.skywind.util;

import java.util.function.IntToLongFunction;

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
}
