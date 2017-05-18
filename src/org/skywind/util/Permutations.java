package org.skywind.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/05/2017.
 */
public class Permutations {

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
