package org.skywind.one;

import java.util.HashMap;
import java.util.Map;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters
 * and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out
 * numbers is in compliance with British usage.
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at: 5/15/17.
 */
public class P017 {

    private static final Map<Integer, String> ones = new HashMap<>();
    private static final Map<Integer, String> tens = new HashMap<>();

    public static void main(String[] args) {
        ones.put(1, "one");
        ones.put(2, "two");
        ones.put(3, "three");
        ones.put(4, "four");
        ones.put(5, "five");
        ones.put(6, "six");
        ones.put(7, "seven");
        ones.put(8, "eight");
        ones.put(9, "nine");
        ones.put(10, "ten");
        ones.put(11, "eleven");
        ones.put(12, "twelve");
        ones.put(13, "thirteen");
        ones.put(14, "fourteen");
        ones.put(15, "fifteen");
        ones.put(16, "sixteen");
        ones.put(17, "seventeen");
        ones.put(18, "eighteen");
        ones.put(19, "nineteen");

        tens.put(2, "twenty");
        tens.put(3, "thirty");
        tens.put(4, "forty");
        tens.put(5, "fifty");
        tens.put(6, "sixty");
        tens.put(7, "seventy");
        tens.put(8, "eighty");
        tens.put(9, "ninety");

        int cnt = 0;
        for (int i = 1; i < 1000; i++) {
            String words = getWords(i);
            System.out.println(words);
            cnt += words.replaceAll("\\s+", "").length();
        }

        cnt += "one thousand".length() - 1;

        System.out.println(cnt);
    }

    private static String getWords(int num) {
        String words = "";
        int h = num / 100;
        if (h > 0) {
            words += ones.get(h) + " hundred";
        }

        num = num % 100;
        if (num == 0) return words;

        if (h > 0) {
            words += " and ";
        }

        if (num >= 20) {
            int d = num / 10;
            words += tens.get(d) + " ";

            int z = num % 10;
            if (z > 0) {
                words += ones.get(z);
            }
        } else {
            words += ones.get(num);
        }
        return words;
    }
}
