package org.skywind.util;

import java.math.BigInteger;
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

        Primes primes = new Primes();
        assertFalse(primes.isPrime(0));
        assertFalse(primes.isPrime(1));
        assertTrue(primes.isComposite(48));
        assertFalse(primes.isComposite(1));
        assertFalse(primes.isComposite(2));

        assertTrue(Digits.isPandigital(12345));
        assertTrue(Digits.isPandigital(12));
        assertTrue(Digits.isPandigital(123456987));

        assertFalse(Digits.isPandigital(103));
        assertFalse(Digits.isPandigital(126));
        assertFalse(Digits.isPandigital(33));

        assertTrue(Digits.isPandigital9(123, 456, 789));
        assertTrue(Digits.isPandigital9(123, 456789));
        assertTrue(Digits.isPandigital9(123456789));
        assertTrue(Digits.isPandigital9(987, 456, 321));

        assertFalse(Digits.isPandigital9(12, 34, 5));
        assertFalse(Digits.isPandigital9(12345));

        assertTrue(Digits.isPandigital10(0, 123, 456, 789));
        assertTrue(Digits.isPandigital10(0, 123, 456789));
        assertTrue(Digits.isPandigital10(0, 123456789));
        assertTrue(Digits.isPandigital10(0, 987, 456, 321));
        assertTrue(Digits.isPandigital10(1_023_456_789));
        assertTrue(Digits.isPandigital10(1234567890L));

        assertFalse(Digits.isPandigital10(0, 12, 34, 5));
        assertFalse(Digits.isPandigital10(12345));

        assertEquals(0, Search.binary(new int[]{1, 2, 3, 4}, 1));
        assertEquals(2, Search.binary(new int[]{1, 2, 4, 5}, 3));

        assertEquals("1234", Palindrome.reverse(new BigInteger("4321")).toString());
        assertEquals("1", Palindrome.reverse(new BigInteger("10")).toString());
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
