package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.ExtMath;

import java.util.stream.IntStream;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 * <p>
 * 0.123456789101112131415161718192021...
 * <p>
 * It can be seen that the 12th digit of the fractional part is 1.
 * <p>
 * If d(n) represents the n-th digit of the fractional part, find the value of the following expression.
 * <p>
 * d1 × d10 × d100 × d1000 × d10_000 × d100_000 × d1_000_000
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 26/05/2017.
 */
public class P040 {

    private static int[] spaces = new int[14];

    public static void main(String[] args) {
        int pow = 1;
        do {
            spaces[pow] = lengthOf(pow) + spaces[pow - 1];
        } while (spaces[++pow - 1] < ExtMath.pow(10, 7));

        IntStream posStream = IntStream.iterate(1, x -> x * 10).limit(7);
        System.out.println(posStream.map(P040::getNumberAtPos).reduce(1, (x, y) -> x * y));
    }

    // how many symbols numbers with given capacity take (9 for 1-symbol numbers, 90 for 2-symbol)
    private static int lengthOf(int capacity) {
        return (int) (9 * ExtMath.pow(10, capacity - 1) * capacity);
    }

    private static int getNumberAtPos(int pos) {
        int capacity = 1;
        while (pos > spaces[capacity]) capacity++;
        pos = pos - 1;

        int offsetSymbols = pos - spaces[capacity - 1]; // digit (symbol) offset against first number in capacity group
        int offsetPosition = offsetSymbols / capacity; // number offset against first number in capacity group
        int powerOfTen = (int) ExtMath.pow(10, capacity - 1); // offset against previous capacity group

        int digitPositionInNumber = offsetSymbols % capacity;

        return Digits.getDigits(powerOfTen + offsetPosition).get(digitPositionInNumber);
    }
}
