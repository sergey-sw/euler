package org.skywind.one;

import org.skywind.util.ExtMath;

/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify
 * it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 * <p>
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * <p>
 * There are exactly four non-trivial examples of this type of fraction, less than one in value,
 * and containing two digits in the numerator and denominator.
 * <p>
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 23.05.17.
 */
public class P033 {

    public static void main(String[] args) {
        int ns = 1, ds = 1;

        for (int numerator = 10; numerator < 100; numerator++) {
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                if (numerator % 10 == 0 && denominator % 10 == 0) continue;

                double v = 1.0 * numerator / denominator;

                int n1 = numerator / 10;
                int n2 = numerator % 10;
                int d1 = denominator / 10;
                int d2 = denominator % 10;

                if (n1 == d1 && close(v, 1.0 * n2 / d2)
                        || n1 == d2 && close(v, 1.0 * n2 / d1)
                        || n2 == d1 && close(v, 1.0 * n1 / d2)
                        || n2 == d2 && close(v, 1.0 * n1 / d1)) {
                    System.out.println(numerator + "/" + denominator);
                    ns *= numerator;
                    ds *= denominator;
                }
            }
        }

        System.out.println(ds / ExtMath.gcd(ns, ds));
    }

    private static boolean close(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.0005;
    }
}
