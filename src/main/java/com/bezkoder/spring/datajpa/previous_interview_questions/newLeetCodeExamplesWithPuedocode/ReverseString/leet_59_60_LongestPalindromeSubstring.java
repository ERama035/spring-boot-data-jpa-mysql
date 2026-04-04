package com.bezkoder.spring.datajpa.previous_interview_questions.newLeetCodeExamplesWithPuedocode.ReverseString;

// puedo code

/*
LongestPalindromeSubstring(s):
    if s==null or s.length < 1;
     return ""
    Start =0 , end =0
for i from 0 to s.length -1:
    len1 = expandAroundCenter(s,i,i);
    len2 = expandAroundCenter(s,i,i+1);
    len= max(len1,len2)
if len > end- start;
  start = i - (len-1)/2;
  end = i+len/2;
  return s.substring(start,end+1)

        expandAroundCenter(s,left,right):
        L = left, R= right;
  while L>=0 && R < s.length && s.charAt(L) == s.charAt(R):
        L--;
        R++;
return R-L-1;
*/

// diferent methods are dynamic programing or 2 pointer approach , expandAroundcenter
public class leet_59_60_LongestPalindromeSubstring {

// expandAroundcenter
 /*   private static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        //int i = 0, j = 0;
        int start = 0, end = 0;
        for (int i=0;i <=s.length();i++ ){
            int length1 = expandAroundCenter(s,i,i);
            int length2 =  expandAroundCenter(s,i,i+1);
            int len = Math.max(length1,length2);

            if(len > start - end){
                start = i - (len -1) /2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private static int expandAroundCenter(String s, int start, int end){
        int L = start, R= end;
            while( L >=0 && R < s.length() && s.charAt(L) == s.charAt(R)){
                L--;
                R++;
            }
        return R-L-1;
    }
*/

// expandAroundcenter
    public static String longestPalindromeSubString(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
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


    public static void main(String[] args) {
        String input="cbbd";
        System.out.println(""+longestPalindromeSubString(input));
        System.out.println(""+countLongestPalindromeSubstrings(input));
    }
}
