package org.skywind.util;

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
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError("Expected " + expected + " but got " + actual);
    }
}
