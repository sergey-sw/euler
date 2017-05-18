package org.skywind.one;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/05/2017.
 */
public class P019 {

    public static void main(String[] args) {
        LocalDate current = LocalDate.of(1901, 1, 1);
        LocalDate end = LocalDate.of(2000, 12, 31);
        int counter = 0;

        while (current.isBefore(end)) {
            if (current.getDayOfWeek() == DayOfWeek.SUNDAY && current.getDayOfMonth() == 1) {
                counter++;
            }
            current = current.plusDays(1);
        }

        System.out.println(counter);
    }
}
