package com.bezkoder.spring.datajpa.newLeetCodeExamplesWithPuedocode.ReverseString;

import java.util.HashMap;
import java.util.Stack;

// puedo code
/*
ReverseString(s):
    left = 0;
    right = s.length -1;
  while(left < right):
    temp = s[left]
    s[left] = s[right]
    s[right] = tmp;
    left++;
    right--
*/


public class leet_57_ValidParentheses {


    public static void main(String[] args) {
        String input = "{()}";
        System.out.println("one :: " + isValidParentheses(input));
        System.out.println("one ::: " + isValidStringCheck(input));

    }


    // simple stack problesm
     public static boolean isValidParentheses(String s) {
            if (s.length() % 2 != 0) return false;
            Stack<Character> stacks = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stacks.push(c);
                } else if (c == ')' && !stacks.isEmpty() && stacks.peek() == '(') {
                    stacks.pop();
                } else if (c == '}' && !stacks.isEmpty() && stacks.peek() == '{') {
                    stacks.pop();
                } else if (c == ']' && !stacks.isEmpty() && stacks.peek() == '[') {
                    stacks.pop();
                }
            }
            return stacks.isEmpty();
        }

     public static Boolean isValidStringCheck(String s) {
            if (s.length() < 2) return false;
            HashMap<Character, Character> map = new HashMap<Character, Character>();
            map.put('}', '{');
            map.put(')', '(');
            map.put(']', '[');
            Stack<Character> stackArray = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (map.containsKey(curr)) {
                    char pop = stackArray.size() != 0 ? stackArray.pop() : '#';
                    if (pop != map.get(curr)) {
                        return false;
                    }
                } else {
                    stackArray.push(curr);
                }
            }
            return stackArray.isEmpty();
        }




}