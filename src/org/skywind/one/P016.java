package org.skywind.one;

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/14/17.
 */
public class P016 {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("2").pow(1000);
        int sum = n.toString().chars().map(c -> c - '0').sum();
        System.out.println(sum);
    }
}
