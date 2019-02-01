package de.umr.oop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOStreams {

    public static Stream<String> words(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath)).lines().map(line -> line.replaceAll("\\p{Punct}","")).flatMap(x -> Arrays.stream(x.split(" ")));
    }

    public static Stream<String> encrypt(Stream<String> words, int offset) {
        return words.map(word -> word.toUpperCase().replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE").replace("ß", "SS")).map(word -> word.chars().map(c -> (char) (c + offset - 65) % 26 + 65).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
    }

    public static Map<String, Integer> countWords(Stream<String> words) {
        return words.map(String::toLowerCase).collect(Collectors.toMap(x -> x, x -> 1, Integer::sum));
    }
}
