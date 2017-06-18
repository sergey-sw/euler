package org.skywind.one;

import org.skywind.util.Triple;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.skywind.util.Numbers.isSqrt;

/**
 * How many continued fractions for N ≤ 10000 have an odd period?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 12/06/2017.
 */
public class P064 {

    public static void main(String[] args) {
        System.out.println(IntStream.range(2, 10001)
                .filter(x -> !isSqrt(x))
                .map(P064::getPeriod)
                .filter(x -> x % 2 == 1)
                .count()
        );
    }


    // https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
    private static int getPeriod(int n) {
        int m_prev = 0;
        int d_prev = 1;
        int sqrt = (int) Math.sqrt(n);
        int a_prev = sqrt;

        Set<Triple<Integer, Integer, Integer>> set = new LinkedHashSet<>();
        set.add(new Triple<>(m_prev, d_prev, a_prev));

        do {
            int m_next = d_prev * a_prev - m_prev;
            int d_next = (n - m_next * m_next) / d_prev;
            int a_next = (sqrt + m_next) / d_next;

            Triple<Integer, Integer, Integer> next = new Triple<>(m_next, d_next, a_next);
            if (set.contains(next)) {
                return set.size() - 1;
            } else {
                set.add(next);

                m_prev = m_next;
                d_prev = d_next;
                a_prev = a_next;
            }
        } while (true);
    }
}
