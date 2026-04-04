package com.bezkoder.spring.datajpa.previous_interview_questions.newLeetCodeExamplesWithPuedocode.ReverseString;

public class leet_58_ValidPalindrome {

    // 2 pointer method by nick white or expand around center
    public boolean isPalindrom(String s){
        int a_pointer = 0;
        int b_pointer = s.length()-1;
        while(a_pointer <= b_pointer){
            if(s.charAt(a_pointer) != s.charAt(b_pointer)){
                // call helper method on 2 different substrings.
                return  helperMethod(s,a_pointer+1, b_pointer) ||
                        helperMethod(s, a_pointer,b_pointer-1);
                // return false;
            }
            a_pointer++;
            b_pointer--;
        }
        return true;
    }

    public boolean helperMethod(String s, int i , int j){
        int a_pointer = i;
        int b_pointer = j;
        while(a_pointer <= b_pointer){
            if(s.charAt(a_pointer) != s.charAt(b_pointer)){
                return false;
            }
            a_pointer++;
            b_pointer--;
        }
        return true;
    }



    // another way  for 2 pointer method by nick white
    public boolean isPalindromeWithIgonrecase(String s){
        String fixed_string ="";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                fixed_string +=c;
            }
        }
        fixed_string = fixed_string.toLowerCase();
        int a_pointer = 0;
        int b_pointer = fixed_string.length() -1;

        while(a_pointer <= b_pointer){
            if(fixed_string.charAt(a_pointer) != fixed_string.charAt(b_pointer)){
                return false;
            }
            a_pointer +=1;
            b_pointer -=1;
        }

        return true;
    }

    // another way using 2 pointer
    public boolean isEquals(String s){
        int p1 = 0, p2 = s.length() -1;
        while(p1 <= p2){
            char c1 = s.charAt(p1), c2 = s.charAt(p2);
            if(Character.isLetterOrDigit(c1) == false){
                p1++;
            } else if (Character.isLetterOrDigit(c2) == false) {
                p2--;
            } else{ // if this hits here it is not a palindrome
                if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                    return false;
                }
                p1++;
                p2--;
            }
        }
        return true;
    }

    // another way using 2 pointer
    //https://www.youtube.com/watch?v=UPdSViixmDs&ab_channel=NickWhite
    public boolean isPalindromeForNumbers(int x){
     if(x == 0) {   return true;   }
     // number is less than 0 and reminder is 0
     if (x < 0 || x % 10 == 0){
         return false;
     }
     int reversed_int = 0;
     while(x > reversed_int){
         int pop = x % 10;
         x /= 10;

         reversed_int = (reversed_int * 10 ) + pop; // to remove the last digit
     }
     if(x == reversed_int || x == reversed_int / 10){
         return true;
     } else{
         return false;
     }
   // return false;
    }

}
