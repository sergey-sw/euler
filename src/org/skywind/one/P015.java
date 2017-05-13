package org.skywind.one;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class P015 {

    public static void main(String[] args) {
        System.out.println(routes(2, 2));
        System.out.println(routes(3, 2));
        System.out.println(routes(4, 4));
        System.out.println(routes(20, 20));
    }

    private static Map<Long, Long> sumCache = new HashMap<>();

    private static long routes(long x, long y) {
        if (x < y) {
            long tmp = x;
            x = y;
            y = tmp;
        }

        if (x + y < 1) return 1;

        final long xx = x - 1;
        final long yy = y;
        long key = 1000 * x + y;

        return sumCache.computeIfAbsent(key, k -> LongStream.rangeClosed(0, yy).map(_y -> routes(xx, _y)).sum());
    }
}
