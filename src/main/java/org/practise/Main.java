package org.practise;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(reverseStringII("train"));

    }

    public static String reverseString(String str ){
        return Stream.of(str)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining());
    }

    public static String reverseStringII(String str ) {
        return IntStream.range(0, str.length())
                .map(i -> str.charAt(str.length() - i - 1))
                .collect(StringBuilder::new,
                        (sb, c) -> sb.append((char) c),
                        StringBuilder::append).toString();
    }
}