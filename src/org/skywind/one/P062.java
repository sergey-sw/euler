package org.skywind.one;

import org.skywind.util.Digits;
import org.skywind.util.SimpleTC;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.skywind.util.ExtMath.powToBigInt;

/**
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3).
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 * <p>
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 04/06/2017.
 */
public class P062 {

    public static void main(String[] args) {
        List<BigInteger> list = IntStream.range(0, 10000).mapToObj(x -> powToBigInt(x, 3)).collect(toList());
        Map<Integer, List<BigInteger>> sum2Bi = list.stream().collect(Collectors.groupingBy(x -> Digits.getDigits(x).sum()));
        Map<BigInteger, List<Integer>> bi2Digits = list.stream().collect(Collectors.toMap(
                k -> k,
                k -> Digits.getDigits(k).sorted().boxed().collect(Collectors.toList()))
        );

        SimpleTC<BigInteger> tc = new SimpleTC<>();

        for (List<BigInteger> groups : sum2Bi.values()) {
            for (int i = 0; i < groups.size(); i++) {
                for (int j = i + 1; j < groups.size(); j++) {
                    if (bi2Digits.get(groups.get(i)).equals(bi2Digits.get(groups.get(j)))) {
                        tc.add(groups.get(i), groups.get(j));
                    }
                }
            }
        }

        tc.run(group -> {
            if (group.size() == 5) {
                System.out.println(group);
            }
        });
    }
}
