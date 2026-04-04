package com.bezkoder.spring.datajpa.leetcode_revisiono;

import java.util.*;

public class AnagramConcept {

    public static boolean isValidAnagram(String s, String t){
        if(s.length() != t.length()){ return false; }
        int[] char_count = new int[26];
        for (int i=0; i < s.length(); i++) {
            char_count[s.charAt(i) - 'a']++;
            char_count[t.charAt(i) - 'a']--;
        }
        for(int char_counts : char_count){
            if(char_counts!=0){
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> isValidGroupAnagram(String[] str){
        Map<String, List<String>> map = new HashMap<>();
        for(String strs: str){ //abc
            char[] chr= strs.toCharArray();// single character
            Arrays.sort(chr);
            String sortedStr = new String(chr);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(strs);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String input1="one";
        String input2="one";
        String[] stringInput= {"one","one"};
        //System.out.println(""+isValidAnagram(input1,input2));
        System.out.println("-: --"+isValidGroupAnagram(stringInput));
    }

}
