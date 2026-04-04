package com.bezkoder.spring.datajpa.allLeetExamples;

import java.util.HashMap;

public class RanSomeNote {
    public static boolean canConstructs(String ransomNote, String magazine) {
        int[] letterAlphabets = new int[26];
        int ransomNoteLength = ransomNote.length();
        int magazineLength = magazine.length();

        for(int i=0; i< ransomNote.length();i++){
            char c = magazine.charAt(i);
            letterAlphabets[c-'a']++; // not sure. adding

            c = ransomNote.charAt(i);
            letterAlphabets[c-'a']--; // not sure.. removing
        }

        for(int i=ransomNoteLength; i < magazineLength; i++){
            char c = magazine.charAt(i);
            letterAlphabets[c-'a']++; // adding alphabets
        }

        for(int i=0; i < letterAlphabets.length; i++){
            if(letterAlphabets[i] < 0){
                return false;
            }
        }
        return true;
    }

    // solution using hash map
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1); // whay adding 1

        for(char c1: ransomNote.toCharArray()){
            // if ransonNote is not in mazine --> return false
            if(!map.containsKey(c1) || map.get(c1) < 1) return false;
            // put ransomeNote is in mazine by using hasmap.
            if(map.containsKey(c1)){
                map.put(c1 , map.get(c1)-1); // not sure why -1
            }

        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("----ransomeNote---- :: "+ canConstruct("ma","rama"));
        System.out.println("----ransomeNote ---- :: "+ canConstructs("ma","rama"));
    }
}
