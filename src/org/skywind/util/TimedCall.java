package org.skywind.util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 04/03/2019.
 */
public class TimedCall<T> {

    private T result;
    private long time;

    public TimedCall(T result, long time) {
        this.result = result;
        this.time = time;
    }

    public T getResult() {
        return result;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return Objects.toString(result) + " in " + formatTime();
    }

    private String formatTime() {
        if (time > 10_000_000) {
            return (time / 1_000_000) + " ms";
        } else {
            return time + " nano seconds";
        }
    }

    public static <T> TimedCall<T> call(Supplier<T> supplier) {
        int iterations = 50;

        long start = System.nanoTime();
        Set<T> results = new HashSet<>();

        for (int i = 0; i < iterations; i++) {
            results.add(supplier.get());
        }

        if (results.size() != 1) {
            throw new IllegalStateException("TimedCall function returned different results: " + results);
        }

        long end = System.nanoTime();

        return new TimedCall<>(results.iterator().next(), (end - start) / iterations);
    }
}
