package org.skywind.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 23.05.17.
 */
public class Digits {

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
        return digits;
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
}
