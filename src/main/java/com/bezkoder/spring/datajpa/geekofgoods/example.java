package com.bezkoder.spring.datajpa.geekofgoods;

public class example {

    // 2 pointer method
    public static char[] reverseWordsString(char[] chars){
        int start = 0;
        for(int end=0; end < chars.length; end++){
            // if we see a space reverse the previous word
            if(chars[end] == ' ' || chars[end] == '-'){
                reverse(chars,start,end);
                start = end + 1; // increment start
            }
        }
        // reverse the last word
        reverse(chars, start,chars.length - 1);

        // reverse the entire string
        reverse(chars,0,chars.length - 1);
        return chars;
    }

    public static void reverse(char chars[], int start, int end){
        char temp;
        while(start <= end){
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end --;
        }
    }

    public static String reverseWordString(String str)
    {
        String s[] = str.split(" ");
        String ans = "";
        for (int i = s.length - 1; i >= 0; i--) {
            ans += s[i] + " ";
        }
        return (ans.substring(0, ans.length() - 1));
    }

    public static String reverseWord(String str)
    {
        StringBuffer sb = new StringBuffer();
        int i = str.length() - 1;
        while(i >= 0){
            if(str.charAt(i) == ' '){
                i--;
            }else{
                int j = i;
                // decrement the i pointer based on ' '
                while(i>=0 && str.charAt(i) != ' '){
                    i--;
                }
                // append the string buffer with ' ' when length > 0
                if(sb.length() > 0){
                    sb.append(' ');
                }
                // append the string buffer starts with i+1 till j;
                for (int k = i + 1; k <= j ; k++) {
                    sb.append(str.charAt(k));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.print(reverseWordsString(s.toCharArray()));
        System.out.print("\n-------------------------\n");
        String s1 = "i like this program very much ";
        System.out.print(reverseWordString(s1));
        System.out.print("--::--"+reverseWord(s1));
        reverseString(s1.toCharArray());
    }


    // Reverse String
    public static void reverseString(char[] s){
        int left =0, right = s.length-1, len = s.length;
        while(left < right){
            char temp = s[left];
            s[left]= s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }


}