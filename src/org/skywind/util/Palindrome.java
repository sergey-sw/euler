package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/05/2017.
 */
public class Palindrome {

    public static boolean check(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) return false;
        }
        return true;
    }

    public static boolean check(int n) {
        int reversed = 0;
        int k = n;
        while (k > 0) {
            reversed = 10 * reversed + k % 10;
            k = k / 10;
        }
        return n == reversed;
    }
}
