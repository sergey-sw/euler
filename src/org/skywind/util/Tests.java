package org.skywind.util;

import java.util.Arrays;
import java.util.Objects;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 23.05.17.
 */
public class Tests {

    public static void main(String[] args) {
        assertEquals(6, ExtMath.gcd(48, 18));
        assertEquals(18, ExtMath.gcd(180, 18));
        assertEquals(12, ExtMath.gcd(48, 180));

        assertEquals(720, ExtMath.lcm(48, 180, 4, 90));
        assertEquals(504, ExtMath.lcm(8, 9, 21));
        assertEquals(42, ExtMath.lcm(6, 21));

        assertEquals(231, Digits.rotationFrom(Arrays.asList(1, 2, 3), 1));

        assertTrue(Palindrome.check("abccba"));
        assertTrue(Palindrome.check("abcba"));
        assertFalse(Palindrome.check("abc"));

        assertTrue(Palindrome.check(1221));
        assertTrue(Palindrome.check(121));
        assertFalse(Palindrome.check(123));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError("Expected " + expected + " but got " + actual);
    }

    private static void assertEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) throw new AssertionError("Expected " + expected + " but got " + actual);
    }

    private static void assertTrue(boolean expression) {
        if (!expression) throw new AssertionError();
    }

    private static void assertFalse(boolean expression) {
        if (expression) throw new AssertionError();
    }
}
