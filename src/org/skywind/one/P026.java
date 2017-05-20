package org.skywind.one;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 20/05/2017.
 */
public class P026 {

    public static void main(String[] args) {
        int num = -1;
        int max = -1;
        for (int i = 2; i < 1000; i++) {
            int length = getRecurringCycle(i).length();
            System.out.println(i + " : " + length);
            if (length > max) {
                max = length;
                num = i;
            }
        }
        System.out.println(num);
    }

    private static String getRecurringCycle(int n) {
        if (n < 1) throw new IllegalArgumentException("Arg should be greater than 1");

        StringBuilder cycle = new StringBuilder("0.");
        int current = 10;
        Set<Integer> numbersInCycle = new HashSet<>();

        do {
            int div = current / n;
            int mod = current % n;

            cycle.append(div);

            if (mod <= 1 || numbersInCycle.contains(mod)) {
                return cycle.toString();
            }

            numbersInCycle.add(mod);
            current = 10 * mod;
        } while (true);
    }
}
