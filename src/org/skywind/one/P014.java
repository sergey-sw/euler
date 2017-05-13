package org.skywind.one;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class P014 {

    public static void main(String[] args) {
        int LIMIT = 1_000_000;

        int maxLength = 0;
        long idx = 0;

        for (long i = 2; i < LIMIT; i++) {
            AtomicInteger length = new AtomicInteger();

            long r = LongStream.iterate(i, generator)
                    .peek(x -> length.incrementAndGet())
                    .filter(x -> x == 1)
                    .findAny().orElse(-1);

            if (r == 1 && length.get() > maxLength) {
                maxLength = length.get();
                idx = i;
            }
        }

        System.out.println(maxLength);
        System.out.println(idx);
    }

    private static LongUnaryOperator generator = n -> n % 2 == 0 ? n / 2 : 3 * n + 1;
}
