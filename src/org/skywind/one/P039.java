package org.skywind.one;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
 * there are exactly three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 26/05/2017.
 */
public class P039 {

    public static void main(String[] args) {
        int max = 0;
        int n_max = 0;
        for (int i = 12; i <= 1000; i += 2) {
            int solutions = getNumberOfSolutionsFor(i);
            System.out.println("n=" + i + ", solutions=" + solutions);
            if (solutions > max) {
                max = solutions;
                n_max = i;
            }
        }
        System.out.println("max for " + n_max + " (" + max + ")");
    }

    private static int getNumberOfSolutionsFor(int n) {
        Set<String> unique = new HashSet<>();
        for (int a = 1; a < n / 2; a++) {
            for (int b = a; b < n / 2; b++) {
                int c = n - a - b;
                if (isValidRightAngleTriangle(a, b, c)) {
                    unique.add(Stream.of(a, b, c).sorted().map(String::valueOf).collect(Collectors.joining("")));
                }
            }
        }
        return unique.size();
    }

    private static boolean isValidRightAngleTriangle(int a, int b, int c) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (b > c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        return a + b > c && a * a + b * b == c * c;
    }
}
