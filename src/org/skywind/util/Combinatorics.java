package org.skywind.util;

import java.math.BigInteger;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 29/05/2017.
 */
public class Combinatorics {

    public static BigInteger getCombinations(int totalSize, int groupSize) {
        BigInteger tf = Factorial.get(totalSize);
        BigInteger gf = Factorial.get(groupSize);
        BigInteger df = Factorial.get(totalSize - groupSize);
        return tf.divide(gf.multiply(df));
    }
}
