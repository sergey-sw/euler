package org.skywind.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/05/2017.
 */
public class Permutations {

    public static List<String> allPermutations(char... chars) {
        if (chars.length == 2) {
            return Arrays.asList("" + chars[0] + chars[1], "" + chars[1] + chars[0]);
        }

        List<String> permutations = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char excluded = chars[i];
            char[] remaining = ArrayTools.exclude(i, chars);
            List<String> remainingPermutations = allPermutations(remaining);
            for (String remainingPermutation : remainingPermutations) {
                permutations.add(excluded + remainingPermutation);
            }
        }
        return permutations;
    }

    public static <T> List<List<T>> getAllPermutations(List<T> originalList) {
        List<List<T>> lists = new ArrayList<>();
        if (originalList.isEmpty()) {
            lists.add(new ArrayList<>());
            return lists;
        }

        List<T> list = new ArrayList<>(originalList);
        T head = list.get(0);
        List<T> rest = new ArrayList<>(list.subList(1, list.size()));
        for (List<T> permutation : getAllPermutations(rest)) {
            List<T> newList = new ArrayList<>();
            newList.add(head);
            newList.addAll(permutation);

            lists.add(newList);
            lists.add(permutation);
        }
        return lists;
    }
}
