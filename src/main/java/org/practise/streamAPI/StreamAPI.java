package org.practise.streamAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        // Given a list of Integers
        System.out.println("list: " + list);

        // find out all the even numbers that exist in the list
        System.out.println("all the even numbers: " + evenNumber(list));

        // find out all the numbers starting with 1
        System.out.println("all the numbers starting with 1: " + startingWithOne(list));

        // How to find distinct elements in a given integers list
        System.out.println("find distinct elements: " + dintinctElements(list));

        // How to find duplicate elements in a given integers list
        System.out.println("find duplicate elements: " + duplicateElements(list));

        // Find the first element of the list
        System.out.println("first element of the list: " + findFirstElement(list));

        // find the total number of elements present in the list
        System.out.println("total number of elements: " + totalNumberOfElementsPresent(list));

        // Find the max value element present in list
        System.out.println("max value: " + findMaxElement(list));

        // Given a String, find the first non-repeated character in it
        String input = "Java articles are Awesome";
        System.out.println("first non-repeated character: " + firstNonRepeatedCharacterInAString(input));

        // Find the first repeated character in the given string
        System.out.println("first repeated character: " + firstRepeatedCharacterInAString(input));

        // Given a list of Integers, sort all the values present in it
        System.out.println("Sorted Values in Ascending Order" + sortValues(list));
        // descending order
        System.out.println("Sorted Values in Descending Order" + sortValues_inDescendingOrder(list));

        // Given an integer arrays nums, return if any value appears
        // at least twice in the array, and return false if every element is distinct
        int[] nums = {10, 15, 8, 49, 25, 98, 98, 32, 15};
        System.out.println("Contains Duplicate: " + containsDuplicate(nums));

        // how will you get the current date and time using Java 8 Date and
        // Time API
        getDateAndTime();
        
        // Java 8 program to concatenate two Streams
        concatTwoStrings();

        //  Java 8 program to perform cube on list elements
        //  and filter numbers greater than 50.
        System.out.println("cuber and >50: " + cubeAndGreaterThanFifty(list));

        //  Write a Java 8 program to sort an array and then
        //  convert the sorted array into Stream?
        System.out.print("sort and covert to Stream: ");
        sortNCovertToStream(nums);

        //  How to use map to convert object into Uppercase in Java 8?
        List<String> nameList = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.println("list to UpperCase: " + listToUpperCase(nameList));

        // How to convert a List of objects into a Map by considering
        // duplicated keys and store them in sorted order?
        System.out.println(" ");

        // 18) How to count each element/word from the String ArrayList in Java8?
        System.out.println("count each element/word: " + countElement(nameList));


    }

    public static List<Integer> evenNumber(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> startingWithOne(List<Integer> list) {
        return list.stream()
                .map(String::valueOf)
                .filter(s -> s.startsWith("1"))     // int -> String
                .map(Integer::valueOf)
                .collect(Collectors.toList());            // String -> int
    }

    public static List<Integer> dintinctElements(List<Integer> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> duplicateElements(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        return list.stream()
                .filter(n -> !set.add(n))
//                .collect(Collectors.toSet());     // can return Set or List
                .collect(Collectors.toList());
    }

    public static Optional<Integer> findFirstElement(List<Integer> list) {
        return list.stream()
                .findFirst();
    }

    public static long totalNumberOfElementsPresent(List<Integer> list) {
        return list.stream()
                .count();
    }

    public static int findMaxElement(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .get();
    }

    public static Character firstNonRepeatedCharacterInAString(String input) {
        return input.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char ) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
    }

    public static Character firstRepeatedCharacterInAString(String input) {
        return input.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char ) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
    }

    public static List<Integer> sortValues(List<Integer> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> sortValues_inDescendingOrder(List<Integer> list) {
        return list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static boolean containsDuplicate(int[] list) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(list)
                .anyMatch(num -> !set.add(num));
    }

    public static void getDateAndTime() {
        // Used LocalDate API to get the date
        System.out.println("Current Local Date: " + LocalDate.now());
        // Used LocalTime API to get the time
        System.out.println("Current Local Time: " + LocalTime.now());
        // Used LocalDateTime API to get the both date and time
        System.out.println("Current Local Date and Time: " + LocalDateTime.now());
    }
    
    public static void concatTwoStrings() {
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "program");
        
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
        concatStream.forEach(str -> System.out.print(str + " "));
        System.out.println();
    }

    public static List<Integer> cubeAndGreaterThanFifty(List<Integer> list) {
        return list.stream()
                .map(i -> i*i*i)
                .filter(i -> i > 50)
                .collect(Collectors.toList());
    }

    public static void sortNCovertToStream(int[] nums) {
        Arrays.sort(nums);
        Arrays.stream(nums)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    public static List<String> listToUpperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> countElement(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        return list.stream()
                .collect(
                Collectors.groupingBy(
                Function.identity(), Collectors.counting()
                ));
    }

}
