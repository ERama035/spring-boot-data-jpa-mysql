package com.bezkoder.spring.datajpa.newLeetCodeExamplesWithPuedocode.ReverseString;

// puedo code
/* reverseWords():
    sb = new String Buffer();
    i = len(s)-1;
    while(i >=0):
      if(s.charAt(i) == '')
          i--;
      esle:
         j=i;
         while(i >=0 && s.charAt(i)!= '');
         i--;
         if(len(sb) > 0):
            sb.append('');
         for k from i+1 to j:
            sb.append(s.charAt(k));
   return sb.toString();
 */

public class leet_344_151_ReverseWordsAndString {

    // leet_151_reverseWords
    private static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int i = s.length() -1; // hre i value is more than 1
        while(i >= 0){
            // decrementing the length if we found ' '
            if(s.charAt(i) == ' ') {
                i--;
            } else {
                // second pointer if we have a word
               int j = i;
                // iterating the word or character
                while( i >=0 && s.charAt(i) != ' '){
                    i--;
                }
                // if word is already present please append the ''
                if(sb.length() > 0){
                    sb.append(' ');
                }
                // append the word with 3rd pointer.
                for(int k=i+1 ; k <=j; k++){
                    sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "one three";
        System.out.println(""+reverseWords(s));

        String string = "i like this program very much ";
        char[] p = reverseWords(string.toCharArray());
        System.out.print(""+p);
    }

    // Function to reverse words from greek of goods
    public  static char[] reverseWords(char[] s) {
        // Reversing individual words as explained in the first step
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            // If we see a space, we  reverse the previous  word (word between  the indexes start and end-1  i.e., s[start..end-1]
            if (s[end] == ' ') {
                reverse(s, start, end);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(s, start, s.length - 1);
        // Reverse the entire String
        reverse(s, 0, s.length - 1);
        return s;
    }

    // Reverse the letters of the word
    public static void reverse(char str[], int start, int end) {
        // Temporary variable  to store character
        char temp;

        while (start <= end) {
            // Swapping the first  and last character
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}

class leetCodeAnswerWorking {
    public String reverseWords1(String s) {
        StringBuffer sb = new StringBuffer();

        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
            } else {
                int j = i;
                while (i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                for (int k = i + 1; k <= j; k++) {
                    sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }
}

class Solutions {
    public String reverseWordsss1(String s) {
        String[] words = s.split(" ");
        int left=0;
        int right = words.length-1;

        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        StringBuilder result = new StringBuilder();
        for(String word: words){
            if(!word.isEmpty()){
                if(result.length() > 0){
                    result.append(" ");
                }
                result.append(word);
            }
        }
        return result.toString();
    }
}
