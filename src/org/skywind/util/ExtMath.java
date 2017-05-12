package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/13/17.
 */
public class ExtMath {

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }

    public static long pow(int number, int power) {
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        return result;
    }
}
