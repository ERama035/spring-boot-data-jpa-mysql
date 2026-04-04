package com.bezkoder.spring.datajpa.newLeetCodeExamplesWithPuedocode.ReverseString;

//puedo code
/*
lengthofLongestsubstring(string s):
len = s.length();
ans =0;
hashTable = new hashMap();
for(i=0, j=0; j< len; j++):
if hashtable.containsKey(s.charAt(j)):
  i = max(hashTable.get(s.charAt(j)),i);
ans = max(ans,j-i+1);
hashTable.put(s.charAt(j),j+1);
return ans;
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// both uses sliding window
public class leet_52_LongestSubstringWithoutRepeating {

    // hashMap // nick white solution
    private static int lengthOfLongestSubstring(String s){
        int  ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1); // left to right
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    // hashMap second method
    private static int lengthOfLongestSubstringWithoutRepeat(String s){
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0 ; right < s.length(); right++) {
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), right);
            } else {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
                map.put(s.charAt(right), right);
            }
            ans = Math.max(ans, right- left + 1); // left to right
        }
        return ans;
    }

    // 2 pointer method
    private static int lengthOfLongestSubstringNorepeat(String s){
        int a_pointer = 0; int b_pointer =0; int max =0;
        HashSet<Character> hashSet= new HashSet<>();
        while (b_pointer < s.length()){
            if(!hashSet.contains(s.charAt(b_pointer))){
                hashSet.add(s.charAt(b_pointer));
                b_pointer++;
                max= Math.max(hashSet.size(),max);
            } else {
                hashSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String input="one";
        String input1="one";
       // System.out.println("--"+lengthOfLongestSubstring(input));
       // System.out.println("-no repeat -"+lengthOfLongestSubstringNorepeat(input));

    }



}
