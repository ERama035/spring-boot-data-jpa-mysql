package com.bezkoder.spring.datajpa.previous_interview_questions.leetcode_revisiono;

public class ValidPalindromeConcept {

   public static Boolean expandAroundCenter(String str, int a,int b){
       int a_pointer = a, b_pointer = b;
       while(a_pointer <= b_pointer){
           if(str.charAt(a_pointer) != str.charAt(b_pointer)){
               // compare by using the subStrings
               return  false;
           }
           a_pointer++;
           b_pointer--;
       }
       return true;
    }


    public static void main(String[] args) {
        String str= "level";
        String str1= "levelabbabba";
        String str2= "abc";
        System.out.print(" str 1::  "+isValidPalindrome(str));
        System.out.print(" str 2 ::  "+isPalindromeWithIgonrecase(str));
        System.out.print(" str 3 ::  "+isLongestPalindromeSubString(str1));
        System.out.print(" :: longestCountSubstrings ::"+countLongestPalindromeSubstrings(str2));

    }

    // 2 pointer method by nick white or expand around center
    public static Boolean isValidPalindrome(String str){
        int a_pointer =0;
        int b_pointer = str.length() - 1;
        while(a_pointer <= b_pointer){
            if(str.charAt(a_pointer) != str.charAt(b_pointer)){
                // compare by using the subStrings
                return  expandAroundCenter(str, a_pointer , b_pointer + 1)  ||
                        expandAroundCenter(str, a_pointer , b_pointer -1);
            }
            a_pointer++;
            b_pointer--;
        }
        return true;
    }

    public static boolean isPalindromeWithIgonrecase(String s){
        String fixed_string = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                fixed_string += c;
            }
        }
        fixed_string = fixed_string.toLowerCase();
    /*
        int a_pointer = 0;
        int b_pointer = fixed_string.length() -1;

        while(a_pointer <= b_pointer){
            if(fixed_string.charAt(a_pointer) != fixed_string.charAt(b_pointer)){
                return false;
            }
            a_pointer +=1;
            b_pointer -=1;
        }
        return true; */
        return isValidPalindrome(fixed_string);
    }

    // expandAroundcenter method by nick white or expand around center
    public static String isLongestPalindromeSubString(String str){
       if(str == null || str.length() < 1) return "";
        int start = 0, end = 0; // end = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {

                // compare by using the subStrings
                int length1 = expandAroundCenterLongestSubString(str, i , i);
                int length2 = expandAroundCenterLongestSubString(str, i , i+1);
                int len = Math.max(length1, length2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int expandAroundCenterLongestSubString(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    // expand aroundcenter or 2 poinbter method
    public static int countLongestPalindromeSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += find(s, i, i);
            count += find(s, i, i + 1);

        }
        return count;
    }
    public static int find(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count += 1;
            left--;
            right++;
        }
        return count;
    }

}
