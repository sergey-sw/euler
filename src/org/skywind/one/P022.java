package org.skywind.one;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Using names.txt, a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name, multiply this value by its alphabetical position
 * in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN,
 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 19/05/2017.
 */
public class P022 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(P022.class.getResource("/p022-names.txt").toURI());
        String str = new String(Files.readAllBytes(path));
        List<String> names = Arrays.stream(str.split(","))
                .map(n -> n.substring(1, n.length() - 1))
                .sorted()
                .collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            sum += (i + 1) * name.chars().map(c -> c + 1 - 'A').sum();
        }
        System.out.println(sum);
    }
}
