package org.skywind.one;

import org.skywind.util.Numbers;
import org.skywind.util.Primes;

import java.util.*;

/**
 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order
 * the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime.
 * The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
 * <p>
 * Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 02/06/2017.
 */
public class P060 {

    private static final Primes p = new Primes(1_0000_0000);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Set<Set<Integer>> sets1 = new LinkedHashSet<>();
        p.toStream().filter(x -> x < 10_000).forEach(x -> sets1.add(Collections.singleton(x)));

        Set<Set<Integer>> sets2 = buildSets(sets1);
        Set<Set<Integer>> sets4 = buildSets(sets2);
        Set<Set<Integer>> sets6 = buildSets(sets4);

        sets6.stream().filter(x -> x.size() == 5).forEach(System.out::println);

        System.out.println("done in: " + (System.currentTimeMillis() - start) / 1000);
    }

    private static Set<Set<Integer>> buildSets(Set<Set<Integer>> src) {
        Set<Set<Integer>> result = new LinkedHashSet<>();

        int idx1 = 0;
        for (Set<Integer> set1 : src) {
            idx1++;

            int idx2 = 0;
            inner:
            for (Set<Integer> set2 : src) {
                if (idx2++ <= idx1) continue inner;

                for (Integer prime1 : set1) {
                    for (Integer prime2 : set2) {
                        if (Objects.equals(prime1, prime2)) continue;

                        if (p.isComposite(prime1 * Numbers.getOrder(prime2) + prime2) ||
                                p.isComposite(prime2 * Numbers.getOrder(prime1) + prime1)) {
                            continue inner;
                        }
                    }
                }

                Set<Integer> newSet = new HashSet<>();
                newSet.addAll(set1);
                newSet.addAll(set2);
                result.add(newSet);
            }
        }
        return result;
    }
}
