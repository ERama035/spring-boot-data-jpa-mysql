package com.bezkoder.spring.datajpa.accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortAndCount {

    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("banana");
        numbers.add("orange");
        numbers.add("apple");
        numbers.add("banana");
        numbers.add("apple");

        // Sort the ArrayList
        Collections.sort(numbers);
        System.out.println("Sorted ArrayList: " + numbers);

        // Count occurrences of each element
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String num : numbers) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }


        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
