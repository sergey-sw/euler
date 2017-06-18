package org.skywind.one;

import org.skywind.util.ResourceTools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 * <p>
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom in triangle.txt, a 15K text file containing a triangle with one-hundred rows.
 * <p>
 * NOTE: This is a much more difficult version of Problem 18.
 * It is not possible to try every route to solve this problem, as there are 2^99 altogether!
 * If you could check one trillion (10^12) routes every second it would take over twenty billion years to check them all.
 * There is an efficient algorithm to solve it. ;o)
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/06/2017.
 */
public class P067 {

    private static final int[][] triangle = new int[100][];

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = ResourceTools.lines("/p067-triangle.txt");
        for (int i = 0; i < lines.size(); i++) {
            triangle[i] = Arrays.stream(lines.get(i).split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        for (int z = 98; z >= 0; z--) {
            for (int i = 0; i < triangle[z].length; i++) {
                triangle[z][i] = Math.max(triangle[z][i] + triangle[z + 1][i], triangle[z][i] + triangle[z + 1][i + 1]);
            }
        }

        System.out.println(triangle[0][0]);
    }
}
