package com.bezkoder.spring.datajpa.newLeetCodeExamplesWithPuedocode.ReverseString;

import java.util.*;

public class leet_187_RepeatedDnaSequences {

    // Barik's : hash amap solution
    public List<String> findRepeatedDnaSequences(String s){
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i < s.length() - 10; i++){
            String subString = s.substring(i, i+10);
            map.put(subString,map.getOrDefault(subString,0) + 1);
        }

        List<String> list= new ArrayList<>();
        for (Map.Entry<String, Integer> item: map.entrySet()){
            if(item.getValue() > 1){
                list.add(item.getKey());
            }
        }
        return list;
    }


    // Bariks : hash set solution
    public List<String> findRepeatedDnaSequencesWithSet(String s){
       Set<String> set = new HashSet<>();
       Set<String> list = new HashSet<>();
        for(int i =0; i < s.length() - 10; i++) {
            String currentString = s.substring(i, i+10);
            if(set.contains(currentString)){
                list.add(currentString);
            }else{
                set.add(currentString);
            }
        }
        return new ArrayList(list);
    }

}
