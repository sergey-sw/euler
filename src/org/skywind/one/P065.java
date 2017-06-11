package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.Pair;

import java.math.BigInteger;

/**
 * Hence the sequence of the first ten convergents for √2 are:
 * <p>
 * 1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
 * What is most surprising is that the important mathematical constant,
 * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
 * <p>
 * The first ten terms in the sequence of convergents for e are:
 * <p>
 * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 * The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
 * <p>
 * Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 12/06/2017.
 */
public class P065 {

    public static void main(String[] args) {
        System.out.println(Digits.getDigits(getNumDen(99).getK()).sum());
    }

    // denominator at position p can be calculated as: (f(p) * n + d) / n
    private static Pair<BigInteger, BigInteger> getNumDen(int pos) {
        BigInteger prev_d = BigInteger.ONE;
        BigInteger prev_n = BigInteger.valueOf(getExpConvergent(pos));

        while (pos > 0) {
            BigInteger next_d = prev_n;
            BigInteger nextAdd = BigInteger.valueOf(getExpConvergent(--pos));
            BigInteger next_n = nextAdd.multiply(prev_n).add(prev_d);

            prev_d = next_d;
            prev_n = next_n;
        }
        return new Pair<>(prev_n, prev_d);
    }

    private static int getExpConvergent(int pos) {
        if (pos-- == 0) return 2;
        return pos % 3 == 1 ? 2 * (pos / 3 + 1) : 1;
    }
}
