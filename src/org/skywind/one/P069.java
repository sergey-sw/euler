package org.skywind.one;

import org.skywind.util.Primes;

import java.util.stream.IntStream;

/**
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of numbers
 * less than n which are relatively prime to n.
 * For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
 * <p>
 * n	Relatively Prime	φ(n)	n/φ(n)
 * 2	1	                 1	      2
 * 3	1,2	                 2	    1.5
 * 4	1,3	                 2     	2
 * 5	1,2,3,4	             4  	1.25
 * 6	1,5	                 2  	3
 * 7	1,2,3,4,5,6	         6  	1.1666...
 * 8	1,3,5,7	             4  	2
 * 9	1,2,4,5,7,8	         6  	1.5
 * 10	1,3,7,9	             4  	2.5
 * <p>
 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 * <p>
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/06/2017.
 */
public class P069 {

    public static void main(String[] args) {
        int[] primes = new Primes().toStream().toArray();
        int res = 0;
        for (int i = 2; i < 100; i++) { // multiply first primes until get a result
            int n = IntStream.range(0, i).map(z -> primes[z]).reduce(1, (a, b) -> a * b);
            if (n > 1_000_000) {
                System.out.println(res);
                return;
            } else {
                res = n;
            }
        }
    }
}
