package org.skywind.one;

import org.skywind.util.ResourceTools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Each character on a computer is assigned a unique code and the preferred standard is ASCII
 * (American Standard Code for Information Interchange).
 * For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 * <p>
 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value,
 * taken from a secret key. The advantage with the XOR function is that using the same encryption key on the cipher text,
 * restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 * <p>
 * For unbreakable encryption, the key is the same length as the plain text message,
 * and the key is made up of random bytes. The user would keep the encrypted message and the encryption key
 * in different locations, and without both "halves", it is impossible to decrypt the message.
 * <p>
 * Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
 * If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
 * The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
 * <p>
 * Your task has been made easy, as the encryption key consists of three lower case characters.
 * Using cipher.txt, a file containing the encrypted ASCII codes,
 * and the knowledge that the plain text must contain common English words, decrypt the message and find
 * the sum of the ASCII values in the original text.
 * <p>
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 01/06/2017.
 */
public class P059 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Set<String> words = new HashSet<>(ResourceTools.wordsFromFile("/p042-words.txt"));
        String cypher = ResourceTools.toString("/p059-cypher.txt");

        int[] codes = Arrays.stream(cypher.split(",")).map(Integer::valueOf).mapToInt(Integer::valueOf).toArray();

        int[] chars = IntStream.range(0, 26).map(x -> x + 'a').toArray();

        for (int c1 : chars) {
            for (int c2 : chars) {
                for (int c3 : chars) {
                    if (tryKey(codes, new int[]{c1, c2, c3}, words)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean tryKey(int[] cypher, int[] key, Set<String> words) {
        char[] decoded = new char[cypher.length];
        int sum = 0;

        for (int i = 0; i < decoded.length; i++) {
            decoded[i] = (char) (cypher[i] ^ key[i % 3]);
            sum += decoded[i];
        }

        String decodedString = new String(decoded);
        String[] parts = decodedString.split("[\\s,]");
        long found = Arrays.stream(parts).map(String::toUpperCase).filter(words::contains).count();

        if (found > parts.length / 2) {
            System.out.println(decodedString);
            System.out.println(sum);
            return true;
        }
        return false;
    }
}
