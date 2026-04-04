package com.bezkoder.spring.datajpa.previous_interview_questions.newLeetCodeExamplesWithPuedocode.ReverseString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leet_61_EncodeAndDecode {
    public String encode(List<String> strs){
        String encode = "";
        for(String s : strs){
            encode = encode + s.length() + '#' + s;
        }
        return encode;
     }

    public List<String> decode(String strs){
        List<String> list = new ArrayList<>();
        int i=0;
        while( i < strs.length()){
            int j =i ;
            while (strs.charAt(j) != '#') j++;
            int len = Integer.parseInt(strs, i , j , 10);
            list.add(strs.substring(j + 1, j + len + 1));
            i = j + len + 1;
        }

        return list;
    }


    // nick white decode
    public static String decodeString(String s){
        Stack<Integer> counts = new Stack(); // count the numbers
        Stack<String> result = new Stack(); // identify the strings or characters

        String res ="";
        int index = 0;

        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index) - '0');
                    index += 1;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                result.push(res);
                res = "";
                index += 1;
           } else if (s.charAt(index) == ']') {
             StringBuilder temp = new StringBuilder(result.pop());
             int count = counts.pop();
                for (int i=0; i< count;i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index += 1;
         } else {
                res += s.charAt(index);
                index += 1;
            }
        }
        return res;
    }

    public static void main(String[] args){

        String input1= "2[c]3[b]";
        System.out.println("decode :: "+decodeString(input1));

    }
}
