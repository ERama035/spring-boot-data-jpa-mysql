package com.bezkoder.spring.datajpa.previous_interview_questions.allLeetExamples;

import java.util.Stack;

public class ValidParantheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray() ) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char top = stack.peek();
                    if(  (c == ')' && top == '(')  ||
                         (c == '}' && top == '{' ) ||
                         (c == ']' && top == '[' )
                       ){
                          stack.pop();
                    } else{
                        return false;
                    }
                }
            }
        }
    return stack.isEmpty();
    }

    public static boolean isValidWithIf(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0;i< s.length();i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                   stack.push(s.charAt(i));
                } else if(stack.empty()) {
                    return false;
                } else if ((s.charAt(i) == ')' && stack.peek() == '(' ) ||
                           (s.charAt(i) == '}' && stack.peek() == '{' ) ||
                           (s.charAt(i) == ']' && stack.peek() == '[' )) {
                    stack.pop();
                } else {
                    return false;
                }
        }
        return stack.isEmpty();
    }

    public static boolean isValidWithSwitch(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray() ) {
             switch (c){
                 case '(':
                 case '{':
                 case '[':
                     stack.push(c);
                     break;
                 case ')':
                     if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                     }
                     break;
                 case '}':
                     if(stack.isEmpty() || stack.pop() != '{'){
                         return false;
                     }
                     break;
                 case ']':
                     if(stack.isEmpty() || stack.pop() != '['){
                         return false;
                     }
                     break;
             }
        }
        return stack.isEmpty();
    }


    public static void main(String []args){
        String strings= "{}()";
        System.out.println("----::----"+isValid(strings));
        System.out.println("----::----"+isValidWithSwitch(strings));
        System.out.println("----::----"+isValidWithIf(strings));
    }
}