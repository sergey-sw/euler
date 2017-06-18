package org.skywind.one;

import org.skywind.util.Numbers;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Consider quadratic Diophantine equations of the form:
 * <p>
 * x^2 – Dy^2 = 1
 * <p>
 * For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.
 * <p>
 * It can be assumed that there are no solutions in positive integers when D is square.
 * <p>
 * By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
 * <p>
 * 3^2 – 2×2^2 = 1
 * 2^2 – 3×1^2 = 1
 * 9^2 – 5×4^2 = 1
 * 5^2 – 6×2^2 = 1
 * 8^2 – 7×3^2 = 1
 * <p>
 * Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
 * <p>
 * Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 14/06/2017.
 */
public class P066 {

    public static void main(String[] args) {
        final BigInteger[] max_x = {ZERO};
        final AtomicInteger best_d = new AtomicInteger(0);

        IntStream.range(2, 1001).filter(D -> !Numbers.isSqrt(D)).forEach(D -> {
            BigInteger x = solve(BigInteger.valueOf(D));
            System.out.println("solution for " + D + " is " + x);

            if (x.compareTo(max_x[0]) > 0) {
                max_x[0] = x;
                best_d.set(D);
            }
        });

        System.out.println(max_x[0]);
        System.out.println(best_d);
    }

    private static BigInteger solve(BigInteger D) {
        BigInteger n1 = BigInteger.ZERO;
        BigInteger d1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;
        BigInteger d2 = BigInteger.ZERO;

        while (true) {
            BigInteger a = n1.add(n2);
            BigInteger b = d1.add(d2);

            BigInteger asqr = a.multiply(a);
            BigInteger bsqr = b.multiply(b);

            BigInteger f = asqr.subtract(D.multiply(bsqr));

            if (f.equals(ONE)) {
                return a;
            } else {
                if (f.compareTo(ZERO) > 0) {
                    n2 = a;
                    d2 = b;
                } else {
                    n1 = a;
                    d1 = b;
                }
            }
        }
    }
}
