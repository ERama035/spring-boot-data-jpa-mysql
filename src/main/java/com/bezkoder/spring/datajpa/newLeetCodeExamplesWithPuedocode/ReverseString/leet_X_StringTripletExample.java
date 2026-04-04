package com.bezkoder.spring.datajpa.newLeetCodeExamplesWithPuedocode.ReverseString;

/*
        Write a Java program to check if two strings are anagrams.
        An anagram is a word or phrase formed by rearranging the letters of another.
 */

import java.util.Arrays;

public class leet_X_StringTripletExample {

        public static boolean increasingTriplet(int[] nums) {
            int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num <= i) {
                    i = num;
                }
                else if (num <= j) {
                    j = num;
                }
                else {
                    return true;
                }
            }
            return false;
        }


    public static void main(String[] args){

        String input1= "cat";
        String input2= "act";
        int[] nums = new int[]{1, 2, 3,4,5,6,7};
        System.out.println(increasingTriplet(nums));

    }

}


