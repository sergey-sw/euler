package org.skywind.one;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 12.05.17.
 */
public class P002 {

    public static void main(String[] args) {
        int MAX = 4_000_000;

        int sum = 0;
        for (int a = 1, b = 2, tmp; b < MAX; tmp = a, a = b, b = tmp + b) {
            if (b % 2 == 0) {
                sum += b;
            }
        }
        System.out.println(sum);
    }
}