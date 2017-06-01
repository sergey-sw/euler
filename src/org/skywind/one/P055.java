package org.skywind.one;

import org.skywind.util.Palindrome;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 * <p>
 * Not all numbers produce palindromes so quickly. For example,
 * <p>
 * 349 + 943 = 1292,
 * 1292 + 2921 = 4213
 * 4213 + 3124 = 7337
 * <p>
 * That is, 349 took three iterations to arrive at a palindrome.
 * <p>
 * Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
 * A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
 * Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that
 * a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand,
 * it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing power
 * that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be shown to
 * require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).
 * <p>
 * Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
 * <p>
 * How many Lychrel numbers are there below ten-thousand?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 01/06/2017.
 */
public class P055 {

    public static void main(String[] args) {
        System.out.println(IntStream.range(0, 10000).filter(P055::isLychrelNumber).count());
    }

    private static boolean isLychrelNumber(int x) {
        BigInteger b = new BigInteger(String.valueOf(x));
        for (int i = 0; i < 50; i++) {
            b = b.add(Palindrome.reverse(b));
            if (Palindrome.check(b)) {
                return false;
            }
        }
        return true;
    }
}