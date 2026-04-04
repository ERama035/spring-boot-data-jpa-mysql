package com.bezkoder.spring.datajpa.allLeetExamples;

public class ValidPalindrome {

    public boolean isPalindrom(String strin) {

        StringBuilder sb= new StringBuilder();
        for(char ch : strin.toCharArray()){
            Character lowerCase= Character.toLowerCase(ch);
            // remove non-alpha characters
            if(Character.isLetterOrDigit(ch)){
                sb.append(lowerCase);         // convert to lower case
            }
        }

        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }

        return false;
    }


    public static boolean isPalindrome(String string) {

        //valid string or to check it was null
            if(string.isEmpty()){
                return true;
            }

        // convert to lower case
        String givenString = string.toLowerCase();

        int start = 0;
        int last = string.length() - 1;

        while(start <= last){

            if(!Character.isLetterOrDigit(string.charAt(start))){
                start++;    // check first character is a letter or digit
            } else if (!Character.isLetterOrDigit(string.charAt(last))) {
                last--;             // check last character is a letter or digit
            } else {
                if(Character.toLowerCase(string.charAt(start)) != Character.toLowerCase(string.charAt(last))){
                    return false; // compare first string to the last string
                }
                start++;
                last--;
            }
        }
        return true;
    }


        public static void main(String []args){
            String givenString = "ramar";
            Boolean palindrome= isPalindrome(givenString);
            System.out.println("palindrom :: "+palindrome);
        }


}
