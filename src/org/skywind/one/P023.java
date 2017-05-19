package org.skywind.one;

import org.skywind.util.Divisors;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum
 * of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be
 * written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even
 * though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 19/05/2017.
 */
public class P023 {

    public static void main(String[] args) {
        int limit = 28124;
        int[] abundantNumbers = IntStream.range(2, limit).filter(P023::isAbundant).toArray();
        System.out.println(Arrays.toString(abundantNumbers));
        System.out.println(abundantNumbers.length);

        int sum = 0;
        for (int i = 1; i < limit; i++) {
            if (!canBeRepresentedAsSum(i, abundantNumbers)) {
                System.out.println("match " + i);
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static boolean isAbundant(int n) {
        return Divisors.get(n).stream().reduce(0, Integer::sum) > n;
    }

    private static boolean canBeRepresentedAsSum(int n, int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int candidate = n - numbers[i++];
            if (candidate <= 0) return false;
            if (Arrays.binarySearch(numbers, candidate) >= 0) {
                return true;
            }
        }
        return false;
    }
}
