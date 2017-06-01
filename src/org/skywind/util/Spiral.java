package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 01/06/2017.
 */
public class Spiral {

    public static int[][] getSpiral(int n) {
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

    public static int[] getDiagonalElements(int distance) {
        int diff = 2 * distance;
        int a4 = (diff + 1) * (diff + 1);
        int a3 = a4 - diff;
        int a2 = a3 - diff;
        int a1 = a2 - diff;

        return new int[]{a1, a2, a3, a4};
    }
}
