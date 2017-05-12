package org.skywind.one;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/12/17.
 */
public class P004 {

    public static void main(String[] args) {
        int max = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                if (isPalindrome(i * j)) {
                    max = Math.max(max, i * j);
                }
            }
        }
        System.out.println("Max palindrome: " + max);
    }

    private static boolean isPalindrome(int n) {
        return isPalindrome(String.valueOf(n));
    }

    private static boolean isPalindrome(String s) {
        if (s.length() % 2 == 0) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
