package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.ExtMath;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <p>
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576.
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * <p>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
 * giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * <p>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product
 * of an integer with (1,2, ... , n) where n > 1?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 25/05/2017.
 */
public class P038 {

    public static void main(String[] args) {
        System.out.println(IntStream.range(2, 9).map(P038::findMaxFor).max().orElse(-1));
    }

    private static int findMaxFor(int n) {
        int numberOfDigits = 9 / n;
        int start = (int) ExtMath.pow(10, numberOfDigits - 1);
        int end = start * 10;

        int[] parts = new int[n];
        int max = -1;
        for (int number = start; number < end; number++) {
            for (int j = 0; j < n; j++) {
                parts[j] = (j + 1) * number;
            }
            if (Digits.isPandigital(parts)) {
                int pangital = Integer.valueOf(Arrays.stream(parts).boxed().map(String::valueOf)
                        .collect(Collectors.joining("")));
                max = Math.max(max, pangital);
            }
        }
        return max;
    }
}
