package com.bezkoder.spring.datajpa.previous_interview_questions.leetcode_2_pointer.string_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Palindrome1 {

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


    //check 2 strings are anagram to list
    public List<Integer> FindAnagram(String s, String p){
            List<Integer> result = new ArrayList<>();
            if(s.length() == 0 || s == null) return result;
            int[] char_counts = new int[26];
        for(char c: p.toCharArray()){
            char_counts[c - 'a']++;
        }

        int left = 0,right = 0;
        int count = p.length();

        //sliding window with frequency table
        while(right < s.length()){

            if(char_counts[s.charAt(right++) - 'a'] -- >= 1) count--;

            if(count == 0) result.add(left);

            if(right - left == p.length() && char_counts[s.charAt(left++) - 'a']++ >= 0) count ++;
        }

        return result;
    }

    // palindrome with  2 poinbter method
    // which includes special characters , case
    // example: "A man, a plan, a canal: panama" , output ture
    public Boolean vlaidPalindrome(String s){
            String fixed_string = "";
            for(char c : s.toCharArray()) {
                if (Character.isDigit(c) || Character.isLetter(c)) {
                    fixed_string += c;
                }
            }
                fixed_string= fixed_string.toLowerCase();
                int a_pointer = 0, b_pointer = fixed_string.length() -1;

                while( a_pointer <= b_pointer){
                    if(fixed_string.charAt(a_pointer) <= fixed_string.charAt(b_pointer)){
                            return false;
                    }
                    a_pointer++;
                    b_pointer--;
                }
                return true;
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

    // palindrome with number// example: "121" , output ture
    public Boolean validPalindromeNumber(int s){
            if(s == 0) return true;
            if(s < 0 || s % 10 == 0 ) return false;
            int reversed_int =0;

            // divide into parts
            // first half
            while(s > reversed_int){
                int pop = s % 10; // last digit from the number
                    s /= 10; // to remove the last digit

                reversed_int = (reversed_int * 10) + pop; // increment
            }
            // second half
            if(s == reversed_int || s == reversed_int / 10){
                return true;
            } else{
                return false;
            }
    }

        //longest substring in valid palindrome
        public String validPalindromeNumber(String s){



            return null;
        }

        // reverse words in a given string.
        public static String validReverseWords(String s){

            String s1[] = s.split(" ");

            String ans = "", reverseString = "";
            for (int i = s1.length - 1; i >= 0; i--) {
                ans += s1[i] + " ";
            }
            reverseString = ans.substring(0, ans.length() - 1);
            return (reverseString);
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

       // palindrome permutation
        public boolean validPalindromePermutation(String s){
            int[] char_counts = new int[128];
            for( int i=0; i < s.length(); i++) {
                char_counts[s.charAt(i)]++;
            }

            int count =0;
            for(int i=0; i< 128;i++){
                count += char_counts[i] % 2;
            }
            return count <=1 ?  false : true;
        }

       // longest palindrome solution
        public int validLongestPalindrome(String s){
            int[] char_counts = new int[128];
            for( char c: s.toCharArray()) {
                char_counts[c]++;
            }
            int result =0;
            for(Integer char_count : char_counts ){
                result += char_count / 2 * 2;
                if(result %2 ==0 && char_count % 2 == 1){
                    result +=1;
                }


            }
            return result;
        }

    // distinct palindrome substrings.
    int result =0;
    public int validPalindromeSubstrings(String s){
            for(int i=0; i < s.length(); i++){
            count(s,i,i);
            count(s,i,i+1);
        }
      return  result;
    }
   public void count(String s, int start, int end){
         while(start>=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
             result++;
             start++;
             end++;
         }
   }
}




