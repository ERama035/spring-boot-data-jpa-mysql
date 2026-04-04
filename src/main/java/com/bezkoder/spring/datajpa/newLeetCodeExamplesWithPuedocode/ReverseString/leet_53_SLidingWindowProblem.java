package com.bezkoder.spring.datajpa.newLeetCodeExamplesWithPuedocode.ReverseString;

import java.io.BufferedInputStream;

public class leet_53_SLidingWindowProblem {

    // nick white sliding window problem
    public static int characterReplacement(String s, int k){

        int N = s.length();
        int[] char_counts = new int[26];

        int window_start = 0;
        int max_length = 0;
        int max_count = 0;

        for(int window_end=0; window_end<N; window_end++){
            char_counts[s.charAt(window_end) - 'A']++;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count,current_char_count);

            while(window_end - window_start -max_count + 1 > k){
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_length = Math.max(max_length, window_end-window_start + 1);
        }

        return max_length;
    }

    public  static void main(String []args){

        String reverseStrin= "ABABAAAAA";
        int k = 2;


        System.out.println("------:: ---"+ characterReplacement(reverseStrin,k));
    }


    // sliding window problem
    public static int minimumWindowSubString(String s, int k){

        int N = s.length();
        int[] char_counts = new int[26];

        int window_start = 0;
        int max_length = 0;
        int max_count = 0;

        for(int window_end=0; window_end<N; window_end++){
            char_counts[s.charAt(window_end) - 'A']++;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count,current_char_count);

            while(window_end - window_start -max_count + 1 > k){
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_length = Math.max(max_length, window_end-window_start + 1);
        }

        return max_length;
    }
}
