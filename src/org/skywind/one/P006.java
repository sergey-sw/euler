package org.skywind.one;

import java.util.stream.IntStream;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class P006 {

    public static void main(String[] args) {
        System.out.println("Diff: " + usingBruteForce(100));
        System.out.println("Diff: " + usingFormulas(100));
    }

    private static int usingBruteForce(int n) {
        int sumOfSquares = IntStream.rangeClosed(1, n).map(i -> i * i).sum();
        int sum = IntStream.rangeClosed(1, n).sum();

        return sum * sum - sumOfSquares;
    }

    private static int usingFormulas(int n) {
        int sum = n * ( n + 1) / 2;
        int sumOfSquares = (2 * n + 1) * ( n + 1) * n / 6;

        return sum * sum - sumOfSquares;
    }
}
