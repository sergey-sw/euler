package org.skywind.one;

import org.skywind.util.Spiral;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 21/05/2017.
 */
public class P028 {

    public static void main(String[] args) {
        int[][] spiral5 = Spiral.getSpiral(5);
        System.out.println(diagonalSum(spiral5));

        int[][] spiral1001 = Spiral.getSpiral(1001);
        System.out.println(diagonalSum(spiral1001));
    }



    private static long diagonalSum(int[][] spiral) {
        int n = spiral.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += spiral[i][i] + spiral[n - i - 1][i];
        }
        sum -= spiral[n / 2][n / 2];
        return sum;
    }
}
