package org.skywind.one;

import java.util.HashMap;
import java.util.Map;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 21/05/2017.
 */
public class P031 {

    private static final int[] coins = new int[]{200, 100, 50, 20, 10, 5, 2, 1};
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getNumberOfVariants(2, 0));
        System.out.println(getNumberOfVariants(5, 0));
        System.out.println(getNumberOfVariants(10, 0));
        System.out.println(getNumberOfVariants(20, 0));
        System.out.println(getNumberOfVariants(50, 0));
        System.out.println(getNumberOfVariants(100, 0));
        System.out.println(getNumberOfVariants(200, 0));
    }

    private static int getNumberOfVariants(int amount, int minCoinIdx) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;

        int sum = 0;
        for (int idx = minCoinIdx; idx < coins.length; idx++) {
            int coin = coins[idx];

            final int rest = amount - coin;
            final int childIdx = idx;
            sum += cache.computeIfAbsent(cacheKey(rest, childIdx), key -> getNumberOfVariants(rest, childIdx));
        }

        return sum;
    }

    private static int cacheKey(int a, int b) {
        return 1000 * a + b;
    }
}
