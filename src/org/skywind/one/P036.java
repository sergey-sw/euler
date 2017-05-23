package org.skywind.one;

import org.skywind.util.Palindrome;

import java.util.stream.IntStream;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 23/05/2017.
 */
public class P036 {

    public static void main(String[] args) {
        int sum = IntStream.range(0, 1_000_000)
                .filter(Palindrome::check)
                .filter(x -> Palindrome.check(Integer.toBinaryString(x)))
                .peek(System.out::println)
                .sum();
        System.out.println("sum: " + sum);
    }
}
