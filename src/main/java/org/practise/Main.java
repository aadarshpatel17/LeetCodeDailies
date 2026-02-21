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

        sequence(7);
        sequenceII(7);

    }

    public static void sequence(int n) {
        System.out.print("Sequence: ");
        for (int i = 1; i <= n; i++) {
            long term = 3 + (3L * i * (i - 1)) / 2;
            System.out.print(term + " ");
        }
        System.out.println();
    }

    public static void sequenceII(int n) {
        int term = 3;
        System.out.print(term + " ");

        for (int i = 1; i < n; i++) {
            term += 3 * i;  // add 3, 6, 9, 12, ...
            System.out.print(term + " ");
        }
    }

    public static void countLetterInString(String str) {
        int[] ch = new int[26];
        for (int i = 0; i < str.length(); i++) {
            ch[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (ch[i] != 0) {
                char c = (char) (i + 'a');
                System.out.println(c + " " + ch[i]);
            }
        }

//        Map<Character, Integer> map = new HashMap<>();
//        for(char ch: str.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        return map;
    }

    public static String reverseString(String str) {
        return Stream.of(str)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining());
    }

    public static String reverseStringII(String str) {
        return IntStream.range(0, str.length())
                .map(i -> str.charAt(str.length() - i - 1))
                .collect(StringBuilder::new,
                        (sb, c) -> sb.append((char) c),
                        StringBuilder::append).toString();
    }
}