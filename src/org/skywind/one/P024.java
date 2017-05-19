package org.skywind.one;

import org.skywind.util.Permutations;

/**
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 *
 * The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * 0123456789
 * 0123456798
 * 0123456879
 * 0123456897
 * 0123456978
 * 0123456987
 * 0123457689
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 19/05/2017.
 */
public class P024 {

    public static void main(String[] args) {
        System.out.println(Permutations.allPermutations("0123".toCharArray()));
        System.out.println(Permutations.allPermutations("0123456789".toCharArray()).get(1_000_000 - 1));
    }
}
