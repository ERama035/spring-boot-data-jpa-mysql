package com.bezkoder.spring.datajpa.current_java_interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class simpleTest {

        public static void main(String args[]) {

            firstNonRepeatingCharacter("geeksforgeeks");
            checkAnagram("car", "arc");

            int[] numbers1 = {5, 3, 8, 1, 2};
            int[] numbers2 = {5, 3, 8, 1, 2, 10, 11};
            int[] numsArray = {5, 3, 8,1, 1, 2};
            removeDuplicatesMultipleArrays(numbers1, numbers2 );
            removeDuplicatesSingleArrays(numsArray );
            removeDuplicatess(numsArray);
            
            System.out.println(" -- isPalindrome :: "+isPalindrome("racecar"));
            char[] array = {'h', 'e', 'l', 'l', 'o'};
            String reversed = reverseString(array);
            System.out.println(reversed); // Output: olleh
        }

    
        // 1) Find the first non-repeating character or the longest palindrome in a string.
        public static void firstNonRepeatingCharacter(String str) {

            String nonRepeating
            = str.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream().filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey).collect(Collectors.toList()).toString();         
            System.out.println(nonRepeating);           
        } 


        // anagram with strings
          public static void checkAnagram(String str1, String str2) {
           // if both strings are not same length  then it was not anagram
            if (str1.length() != str2.length()) {
                System.out.println("Not anagram because of less length");
                return;
            } else {
                // sort the strings
                char[] char1 = str1.toCharArray();
                char[] char2 = str2.toCharArray();
                Arrays.sort(char1);
                Arrays.sort(char2);

                // check if both strings are same
                if (Arrays.equals(char1, char2)) {
                    String anagramMessage = String.format("%s : %s : is an Anagram", str1, str2);
                    System.out.println(anagramMessage);
                } else {
                     String notAnagramMessage = String.format("%s : %s : is not an Anagram", str1, str2);
                     System.out.println(notAnagramMessage);
                }
            }
         }

         // anagram with hashmap
         public static List<Integer> findAnagrams(String str1, String str2) {
            // if both strings are not same length  then it was not anagram
            // check str1 is greater than str2 or not
            str1 = str1.length() > str2.length() ? str1 : str2;
            str2 = str1.length() > str2.length() ? str2 : str1;
 


            return null;
         }


        public static int[] removeDuplicatesMultipleArrays(int[] numbers1, int[] numbers2) {
            // [1, 2, 3, 5, 8]
            Arrays.sort(numbers1);
            Arrays.sort(numbers2);

            // Merge the two arrays and get the distinct array
            List<Integer> distinctArray = new ArrayList<>();
            for (int num : numbers1) {
                if (!distinctArray.contains(num)) {
                    distinctArray.add(num);
                }
            }
            for (int num : numbers2) {
                if (!distinctArray.contains(num)) {
                    distinctArray.add(num);
                }
            }
            int[] result = distinctArray.stream().mapToInt(Integer::intValue).toArray();
            // print the result
            for (int num : result) {
                System.out.print(num + " ");
            }

            return result;
        }
         public static int[]  removeDuplicatesSingleArrays(int[] numbers1){
            // remove the duplicates from the array using the java stream api
            numbers1= IntStream.of(numbers1).distinct().toArray();
            // numbers1 sort the array
            Arrays.sort(numbers1);

            System.out.println(" -- numbers1 :: "+Arrays.toString(numbers1));
            return numbers1;             
        }

        public static int removeDuplicatess(int[] nums) {
            int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
            return i+1; // number of unique values
        }

        // palindrome example using 2 pointer
        public static boolean isPalindrome(String s) {
            //check if the string is null or empty
            if(s == null || s.length() == 0) {
                return false;
            }
             int right = s.length() -1;
             int left = 0;
             // loop though the string using right and left
             while (left < right) {

                if(s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
                 
             }


            return true;
        }


        // string reversal
        public static String reverseString(char[] s) {
            int left = 0; 
            int right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
            return new String(s);
        }


}