package org.skywind.one;

import org.skywind.util.Direction;
import org.skywind.util.ExtMath;

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
        int[][] spiral5 = getSpiral(5);
        System.out.println(diagonalSum(spiral5));

        int[][] spiral1001 = getSpiral(1001);
        System.out.println(diagonalSum(spiral1001));
    }

    private static int[][] getSpiral(int n) {
        if (n % 2 == 0) throw new IllegalArgumentException("N should be odd");

        int[][] arr = new int[n][n];
        Direction d = Direction.RIGHT;

        int start = n / 2;
        int x = start, y = start;

        int epoch = 0; // number of cells between border and center minus 1

        for (int i = 1; i <= n * n; i++) {
            arr[y][x] = i;

            if (i == ExtMath.sqr(2 * epoch + 1)) { // epoch is increased at 1, 9, 25, 49 and so on
                epoch++;
            } else if (Math.abs(x - start) == epoch && d.isHorizontal()
                    || Math.abs(y - start) == epoch && d.isVertical()) {
                d = Direction.clockWise(d); // rotate direction when met the border
            }

            y += d.dy;
            x += d.dx;
        }

        return arr;
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
