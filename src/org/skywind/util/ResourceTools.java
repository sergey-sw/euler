package org.skywind.util;

import org.skywind.one.P022;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 26/05/2017.
 */
public class ResourceTools {

    public static List<String> wordsFromFile(String name) throws URISyntaxException, IOException {
        Path path = Paths.get(P022.class.getResource(name).toURI());
        String str = new String(Files.readAllBytes(path));
        return Arrays.stream(str.split(","))
                .map(n -> n.substring(1, n.length() - 1))
                .sorted()
                .collect(Collectors.toList());
    }
}
