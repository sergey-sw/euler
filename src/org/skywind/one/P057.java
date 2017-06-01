package org.skywind.one;

import org.skywind.util.Digits;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 * <p>
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 * <p>
 * By expanding this for the first four iterations, we get:
 * <p>
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 * <p>
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985,
 * is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.
 * <p>
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 01/06/2017.
 */
public class P057 {

    private static final int limit = 1000;
    private static final BigInteger[] numerators = new BigInteger[limit];
    private static final BigInteger[] denumerators = new BigInteger[limit];

    public static void main(String[] args) {
        init();
        System.out.println(IntStream.range(0, limit).filter(P057::expansionMatch).count());
    }

    private static void init() {
        numerators[0] = BigInteger.ONE;
        denumerators[0] = BigInteger.TWO;

        for (int i = 1; i < limit; i++) {
            numerators[i] = denumerators[i - 1];
            denumerators[i] = denumerators[i - 1].multiply(BigInteger.TWO).add(numerators[i - 1]);
        }
    }

    private static boolean expansionMatch(int n) {
        long nd = Digits.getDigits(numerators[n].add(denumerators[n])).count();
        long dd = Digits.getDigits(denumerators[n]).count();
        return nd > dd;
    }
}
