package org.skywind.one;

import org.skywind.util.Fibonacci;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The 12th fibonacci term, F12 = 144, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 19/05/2017.
 */
public class P025 {

    public static void main(String[] args) {
        AtomicInteger idx = new AtomicInteger(-1);
        Fibonacci.getSequence().peek(x -> idx.incrementAndGet())
                .filter(n -> n.toString().length() == 1000)
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println(idx.intValue() + 1);
    }
}
