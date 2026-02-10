package org.practise.random;

import java.util.HashMap;
import java.util.Map;

public class LC242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "anagram";
        System.out.println(isAnagram_approach1(s, t));
    }

    // 242. Valid Anagram
    public static boolean isAnagram_approach1(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char ch : s.toCharArray()) {
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        return mapS.equals(mapT);
    }

    public static boolean isAnagram_approach2(String s, String t) {
        int[] character = new int[26];

        for(int i=0; i<s.length(); i++) {
            character[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            character[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<26; i++) {
            if(character[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
