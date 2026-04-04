package com.bezkoder.spring.datajpa.leetcode_2_pointer.string_problems;

import java.util.*;

public class StringProblems {

    // string duplicates
    public static void StringDuplicates(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();

        for(char c : charArray){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1 );
            } else{
                map.put(c,1);
            }
        }
            /* for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(entry.getValue() > 1){
                    System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
                }
            } */
        map.forEach((key, value) -> {
            if (value > 1) {
                System.out.println("Key: " + key + ", Value: " + value);
            }
        });
    }

    // reverse string in a given array.
    // 2 pointer problem.
    public void validvalidReverseString(char[] s){
        int a_pointer = 0;
        int b_pointer = s.length-1;

        while(a_pointer <= b_pointer){
            char temp = s[a_pointer];
            s[a_pointer] = s[b_pointer];
            s[a_pointer] = temp;

            a_pointer+=1;
            b_pointer-=1;
        }
    }


    // palindrome with  expand aroundcenter
    // which includes special characters , case
    // example: "A man, a plan, a canal: panama" , output ture
    public Boolean validPalindrome2(String s){

        int a1_pointer = 0, b1_pointer = s.length() -1;


        while(a1_pointer <= b1_pointer){
            if(s.charAt(a1_pointer) <= s.charAt(b1_pointer)){
                //return false;
                return helperMethod(s, a1_pointer+1,b1_pointer) ||
                        helperMethod(s, a1_pointer, b1_pointer-1);
            }
            a1_pointer++;
            b1_pointer--;
        }
        return true;
    }
    public Boolean helperMethod(String s, int a1,int b){
        int a11_pointer = 0;
        int b11_pointer = s.length()-1;
        while(a11_pointer <= b11_pointer){
            if(s.charAt(a11_pointer) != s.charAt(b11_pointer)){
                return false;
            }
            a11_pointer++;
            b11_pointer--;
        }
        return true;
    }


    //check 2 strings are anagram
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] char_count= new int[26];
        for(int i=0; i <s.length();i++){
            char_count[s.charAt(i) - 'a']++;
            char_count[t.charAt(i) - 'a']--;
        }
        for(int char_counts: char_count ){
            if( char_counts !=0){
                return false;
            }
        }
        return false;
    }


    // valid anagram
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch_arr = str.toCharArray();
            Arrays.sort(ch_arr);
            String sortedStr = new String(ch_arr);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    //valid parantheses
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                char pop = stack.size() != 0 ? stack.pop() : '#';
                if (pop != map.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }
        return stack.isEmpty();
    }

    // 58. is palindrome
    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;
        while (p1 <= p2) {
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);
            if (Character.isLetterOrDigit(c1) == false) p1++;
            else if (Character.isLetterOrDigit(c2) == false) p2--;
            else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                p1++;
                p2--;
            }
        }
        return true;
    }






    // longestPalindrome
    int start = 0, end = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return s.substring(start, end + 1);
    }
    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left = left + 1; // from left to right => palindromic substring
        right = right - 1;
        if (end - start + 1 < right - left + 1) {
            start = left;
            end = right;
        }
    }


    // 61 encode and decode
    public String encode(List<String> strs) {
        String encoded = ""; // ["lint","code","love","you"] -> "4#lint4#code4#love3#you"
        for (String s : strs) {
            encoded = encoded + s.length() + "#" + s;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str, i, j, 10);
            list.add(str.substring(j + 1, j + len + 1));
            i = j + len + 1;
        }
        return list;
    }

    // 60. palindroime substring
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += find(s, i, i);
            count += find(s, i, i + 1);
        }
        return count;
    }
    public int find(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count += 1;
            left--;
            right++;
        }
        return count;
    }
    // prime numbers


}
