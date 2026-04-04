package com.bezkoder.spring.datajpa.previous_interview_questions.newLeetCodeExamplesWithPuedocode.ReverseString;

// pedo code
/*
  length(strs):
        if(str.lenghth) ==0; return null;
     string prefix = strs[0];
     for i  from 1 to str.lenght-1;
        while str[i].indexOf(prefix) ! =0
            prefix = prefix.subString(0, prefix.length-1);
            if prefix.Isempty;
            return ""
   return prefix;
  */

public class leet_14_LongestCommonPrefix {

    public static String longestCommonPrefixs(String[] strs){
       if(strs.length ==0) return "";
       String prefix = strs[0];
       for(int i=0; i < strs.length;i++){

           while(strs[i].indexOf(prefix) != 0){
               prefix = prefix.substring(0, prefix.length()-1);

               if (prefix.isEmpty()) return "";
           }
       }
        return prefix;
     }


    public static void main(String[] args) {
        String[] str= new String[]{"one three","two four"};
        System.out.println("answer with prefix: "+longestCommonPrefixs(str));

    }
}
