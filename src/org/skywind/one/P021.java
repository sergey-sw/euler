package org.skywind.one;

import org.skywind.util.Divisors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/05/2017.
 */
public class P021 {

    public static void main(String[] args) {
        int n = 10000;
        Map<Integer, Integer> num2Sum = new HashMap<>();

        for (int i = 1; i < n; i++) {
            List<Integer> divisors = Divisors.get(i);
            int sum = divisors.stream().reduce(0, Integer::sum) + 1;
            num2Sum.put(i, sum);
        }

        int total = 0;
        for (Map.Entry<Integer, Integer> e : num2Sum.entrySet()) {
            int num = e.getKey();
            int sum = e.getValue();

            if (num != sum && num2Sum.containsKey(sum) && num2Sum.get(sum) == num) {
                System.out.println(num + " " + sum);
                total += num + sum;
            }
        }

        System.out.println(total / 2);
    }
}
