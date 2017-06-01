package org.skywind.one;

import org.skywind.util.Primes;
import org.skywind.util.Spiral;

import java.io.IOException;
import java.util.stream.IntStream;

/**
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
 * <p>
 * It is interesting to note that the odd squares lie along the bottom right diagonal,
 * but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime;
 * that is, a ratio of 8/13 ≈ 62%.
 * <p>
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed.
 * If this process is continued, what is the side length of the square spiral for which the ratio of primes along
 * both diagonals first falls below 10%?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 01/06/2017.
 */
public class P058 {

    public static void main(String[] args) throws IOException {
        Primes primes = Primes.getBillionPrimes();

        int distance = 1;
        long primeCount = 0;
        while (true) {
            int[] diagonal = Spiral.getDiagonalElements(distance);

            primeCount += IntStream.of(diagonal).filter(primes::isPrime).count();

            if (primeCount / (4.0 * distance + 1) < 0.1) {
                System.out.println(2 * distance + 1);
                return;
            }

            distance++;
        }
    }
}
