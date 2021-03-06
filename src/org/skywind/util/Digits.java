package org.skywind.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 23.05.17.
 */
public class Digits {

    public static IntStream getDigits(BigInteger n) {
        return n.toString().chars().map(x -> x - '0');
    }

    public static List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static List<Integer> getDigits(long n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int) (n % 10));
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static int getNumberOfDigits(long n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    public static int getNumberOfDigits(BigInteger n) {
        return n.toString().length();
    }

    public static List<Integer> getRotations(int n) {
        List<Integer> digits = getDigits(n);
        List<Integer> rotations = new ArrayList<>();

        for (int i = 1; i < digits.size(); i++) {
            rotations.add(rotationFrom(digits, i));
        }

        return rotations;
    }

    public static int rotationFrom(List<Integer> digits, int start) {
        int rotation = digits.get(start);

        for (int i = start + 1; i < digits.size(); i++) {
            rotation = rotation * 10 + digits.get(i);
        }
        for (int i = 0; i < start; i++) {
            rotation = rotation * 10 + digits.get(i);
        }

        return rotation;
    }

    private static int[] digits = new int[10];
    private static int digitCounter = 0;

    public static boolean hasSameDigits(long n) {
        for (int i = 0; i < 10; i++) {
            digits[i] = -1;
        }
        return __hasSameDigits(n);
    }

    // has digits 1-9
    public static boolean isPandigital9(int... parts) {
        return __isPandigital(1, parts);
    }

    // has digits 0-9
    public static boolean isPandigital10(int... parts) {
        return __isPandigital(0, parts);
    }

    private static boolean __isPandigital(int start, int... parts) {
        for (int i = start; i < 10; i++) {
            digits[i] = -1;
        }

        for (int part : parts) {
            if (__hasSameDigits(part)) return false;
        }

        for (int i = start; i < 10; i++) {
            if (digits[i] == -1) return false;
        }
        return true;
    }

    public static boolean isPandigital(long number) {
        digitCounter = 0;
        for (int i = 1; i < 10; i++) {
            digits[i] = -1;
        }

        if (__hasSameDigits(number)) return false;

        for (int i = 1; i < 10; i++) {
            if (digits[i] == -1 && i < digitCounter) return false;
            if (digits[i] == 1 && i > digitCounter) return false;
        }
        return true;
    }

    public static boolean isPandigital10(long number) {
        digitCounter = 0;
        for (int i = 0; i < 10; i++) {
            digits[i] = -1;
        }

        if (__hasSameDigits(number)) return false;

        for (int i = 0; i < 10; i++) {
            if (digits[i] == -1 && i < digitCounter) return false;
            if (digits[i] == 1 && i > digitCounter) return false;
        }
        return true;
    }

    private static boolean __hasSameDigits(long n) {
        if (n == 0) {
            digits[0] = 1;
            digitCounter++;
            return false;
        }

        while (n > 0) {
            int digit = (int) (n % 10);
            if (digits[digit] == -1) {
                digits[digit] = 1;
                n = n / 10;
                digitCounter++;
            } else {
                return true;
            }
        }
        return false;
    }
}
