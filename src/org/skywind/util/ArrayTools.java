package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 19/05/2017.
 */
public class ArrayTools {

    public static void main(String[] args) {
        System.out.println(exclude(3, "queen".toCharArray()));
    }

    public static char[] exclude(int idx, char[] src) {
        char[] result = new char[src.length - 1];
        int pos = 0;
        for (int i = 0; i < src.length; i++) {
            if (i != idx) {
                result[pos] = src[i];
                pos++;
            }
        }
        return result;
    }
}
