package org.skywind.one;

import org.skywind.util.Factorization;

import java.util.Collections;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 12.05.17.
 */
public class P003 {

    public static void main(String[] args) {
        long n = 600851475143L;
        System.out.println(Collections.max(Factorization.getFactors(n)));
    }
}
