package com.bezkoder.spring.datajpa.previous_interview_questions.newLeetCodeExamplesWithPuedocode.ReverseString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet_139_WordBreak {

    // back tracking example.
    public boolean wordBreak(String s, List<String> wordList) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
