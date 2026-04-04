package com.bezkoder.spring.datajpa.leetcode_revisiono;

public class ValidPalindromeConcept1 {

    // 2 pointer method with expand around center
    public static Boolean isValidPalindrome(String s){
        int a_pointer = 0 , b_pointer = s.length() -1;
        while(a_pointer <= b_pointer){
            if(s.charAt(a_pointer) != s.charAt(b_pointer)){
                return expandAroundCenter(s, a_pointer,b_pointer+1) ||
                        expandAroundCenter(s, a_pointer,b_pointer-1);
            }
            // increment and decrement the substrings
                a_pointer++;
                b_pointer--;
        }
        return true;
    }

    public static Boolean expandAroundCenter(String s, int i , int j){
        int a_pointer = i , b_pointer = j;
        while(a_pointer < b_pointer){
            if(s.charAt(a_pointer) != s.charAt(b_pointer)){
                return false;
            }
                a_pointer++;
                b_pointer--;
        }
        return true;
    }

    public static Boolean isPalindromeWithIgonrecase(String s){
        String fixed_str = "";
        for(char chatr : s.toCharArray()){
            if(Character.isDigit(chatr) || Character.isLetter(chatr)){
                fixed_str += chatr;
            }
        }
        fixed_str = fixed_str.toLowerCase();
        return isValidPalindrome(fixed_str);
    }


    public static String isLongestPalindromeSubString(String str){
        if(str == null || str.length() < 1) return "";
        int start = 0, end = 0; // end = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {

            // compare by using the subStrings
            int length1 = expandLongestAroundCenter(str, i , i);
            int length2 = expandLongestAroundCenter(str, i , i+1);
            int len = Math.max(length1, length2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }


    private static int expandLongestAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String str1= "levelabbabba";
        System.out.print(" str 3 ::  "+isLongestPalindromeSubString(str1));

    }

}
