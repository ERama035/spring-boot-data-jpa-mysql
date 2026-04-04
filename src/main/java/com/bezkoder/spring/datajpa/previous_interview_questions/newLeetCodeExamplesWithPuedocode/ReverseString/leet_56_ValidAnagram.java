package com.bezkoder.spring.datajpa.previous_interview_questions.newLeetCodeExamplesWithPuedocode.ReverseString;

import java.util.*;

public class leet_56_ValidAnagram {

    // general anagram;
    public static boolean isAnagram(String s, String t){
        if( s.length() != t.length()) {
            return false;
        }
        int[] char_counts = new int[26];
        for(int i=0; i < s.length(); i++){
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }
        for(int count : char_counts){
            if(count!=0) {
                return false;
            }
        }
        return true;
    }

    // group of anagrams -- hashmap
    public static List<List<String>> isGroupAnagram(String[] string){
        HashMap<String , List<String>> map = new HashMap<>();
        for (String str : string) {
         char[] ch_arr = str.toCharArray();
            Arrays.sort(ch_arr);
            String sortedStr = new String(ch_arr);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strArray= new String[]{"one", "three"};
        String string1 = "string" ,string2 = "string";
        System.out.println("----::--isGroupAnagram-- :: "+isGroupAnagram(strArray));
        System.out.println("----isAnagram---- :: "+isAnagram(string1,string2));
    }


}