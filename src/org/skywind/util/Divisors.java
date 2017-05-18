package org.skywind.util;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 18/05/2017.
 */
public class Divisors {

    public static List<Integer> get(int n) {
        List<Integer> factors = Factorization.getFactors(n);
        List<List<Integer>> powersets = Permutations.getAllPermutations(factors);
        return powersets.stream()
                .filter(elems -> !elems.isEmpty())
                .map(elems -> elems.stream().reduce((a, b) -> a * b))
                .map(Optional::get)
                .filter(x -> x != n)
                .distinct()
                .collect(Collectors.toList());
    }
}
