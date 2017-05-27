package org.skywind.util;

import java.util.Arrays;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 27/05/2017.
 */
public class Search {

    public static int binary(int[] elems, int s) {
        int pos = Arrays.binarySearch(elems, s);
        if (pos < 0) pos = -1 - pos;
        return pos;
    }

    public static int binary(long[] elems, long s) {
        int pos = Arrays.binarySearch(elems, s);
        if (pos < 0) pos = -1 - pos;
        return pos;
    }
}
