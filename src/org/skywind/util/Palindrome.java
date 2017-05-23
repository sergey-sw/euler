package org.skywind.util;

import java.util.List;
import java.util.Objects;

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
        List<Integer> digits = Digits.getDigits(n);
        for (int i = 0; i < digits.size(); i++) {
            if (!Objects.equals(digits.get(i), digits.get(digits.size() - i - 1))) return false;
        }
        return true;
    }
}
