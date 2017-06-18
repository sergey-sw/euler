package org.skywind.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://projecteuler.net/problem=68
 * <p>
 * Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings.
 * What is the maximum 16-digit string for a "magic" 5-gon ring?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/06/2017.
 */
public class P068 {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        IntStream.range(1, 11).forEach(a -> {
            IntStream.range(1, 11).filter(b -> b != a).forEach(b -> {
                IntStream.range(1, 11).filter(c -> c != a && c != b).forEach(c -> {
                    int n = a + b + c;

                    IntStream.range(1, 11).filter(d -> d != a && d != b && d != c).forEach(d -> {
                        int e = n - b - d;
                        if (e <= 0 || e == a || e == b || e == c || e == d) return;

                        IntStream.range(1, 11).filter(f -> f != a && f != b && f != c && f != d && f != e).forEach(f -> {
                            int g = n - f - d;
                            if (g <= 0 || g == a || g == b || g == c || g == d || g == e || g == f) return;

                            IntStream.range(1, 11).filter(h -> !Arrays.asList(a, b, c, d, e, f, g).contains(h)).forEach(h -> {
                                int i = n - f - h;
                                int j = n - a - h;
                                List<Integer> used = Arrays.asList(a, b, c, d, e, f, g, h);
                                if (i <= 0 || j <= 0 || used.contains(i) || used.contains(j)) return;

                                int[][] g1 = {{c, a, b}, {e, b, d}, {g, d, f}, {i, f, h}, {j, h, a}};
                                String s = toStr(rotateToMin(g1));
                                if (s.length() == 16) {
                                    result.add(s);
                                }
                            });
                        });
                    });
                });
            });
        });

        result.forEach(System.out::println);
        System.out.println("--------------");
        System.out.println(Collections.max(result));
    }

    private static int[][] rotateToMin(int[][] penta) {
        int min = 100;
        int pos = -1;
        for (int i = 0; i < 5; i++) {
            if (penta[i][0] < min) {
                min = penta[i][0];
                pos = i;
            }
        }
        int[][] rotated = new int[5][3];
        for (int i = 0; i < 5; i++) {
            rotated[i] = penta[(pos + i) % 5];
        }
        return rotated;
    }

    private static String toStr(int[][] penta) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(String.valueOf(penta[i][j]));
            }
        }
        return sb.toString();
    }
}
