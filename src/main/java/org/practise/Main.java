package org.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        countLetterInString("train");

    }

    public static void countLetterInString(String str) {
        int[] ch = new int[26];
        for(int i=0; i<str.length(); i++) {
            ch[str.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(ch[i] != 0) {
                char c = (char)(i + 'a');
                System.out.println(c + " " + ch[i]);
            }
        }

//        Map<Character, Integer> map = new HashMap<>();
//        for(char ch: str.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        return map;
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