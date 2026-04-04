package com.bezkoder.spring.datajpa.leetcode_revisiono;

import java.util.*;

public class AnagramConcept1 {


    public static Boolean isValidAnagram(String s, String t){
        if(s.length() != t.length()) {return false;}
        int[] counter_count = new int[26];
        for(int i =0; i <= s.length(); i++){
            if(s.charAt(i) < t.charAt(i)){
                counter_count[s.charAt(i) - 'a']++;
                counter_count[t.charAt(i) - 'a']--;
         }
            return true;
        }
        return false;
    }


    public static List<List<String>> isValidGroupAnagram(String[] str){

        HashMap<String, List<String>> map= new HashMap<>();
        for(String s: str){
            char[] c = s.toCharArray(); // single character
            Arrays.sort(c);
            String sortedStr = new String(c);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(s);
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
