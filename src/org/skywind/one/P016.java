package org.skywind.one;

import java.math.BigInteger;

/**
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
