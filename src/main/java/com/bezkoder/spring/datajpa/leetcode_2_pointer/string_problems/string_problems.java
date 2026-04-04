package com.bezkoder.spring.datajpa.leetcode_2_pointer.string_problems;

import java.util.*;

public class string_problems {

    // merge 2 strings
    public String mergeAlternately(String word1, String word2){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < word1.length() || i < word2.length(); i++){

            if(i< word1.length() ){
               sb.append(word1.charAt(i));
            }
            if(i < word2.length()){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    // 1071. Greatest Common Divisor of Strings
    public String gcdOfStrings(String word1, String word2){
        // int len1 = word1.length(), len2= word2.length();
        if(!(word1 + word2).equals(word2 + word1)){
            return "";
        }
        int gcd = gcd(word1.length(), word2.length());

        return word1.substring(0, gcd);
    }
    private int gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

    // 1071. Greatest Common Divisor of Strings
    // solution 2
    //https://www.youtube.com/watch?v=41iKYE0n0PQ
    public String gcdOfStringsss(String str1, String str2){

        if(str2.length() > str1.length()){
            return gcdOfStringsss(str2,str1);
        }
        if(str2.equals(str1)){
            return str1;
        }
        if(str1.startsWith(str2)){
            return gcdOfStrings(str1.substring(str2.length()),str2);
        }

        return "";
    }

    public String gcdOfStringss(String str1, String str2){
        String bigger = str1.length() > str2.length() ? str1: str2;
        String smaller = str1.length() > str2.length() ? str2: str1;

        if(bigger.equals(smaller)){
            return smaller;
        }
        if(!bigger.startsWith(smaller)){
            return "";
        }

        return gcdOfStringss(bigger.substring(smaller.length()), smaller);
    }

   // 1431. Kids With the Greatest Number of Candies
   public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
       List<Boolean> result = new ArrayList<>();
        for(int candy: candies){
            maxCandies =  Math.max(maxCandies, candy);
        }

       for (int candy: candies) {
            if(candy + maxCandies >= maxCandies){
                result.add(true);
            }else{
                result.add(false);
            }
       }
        return result;
   }

   // 605. Can Place Flowers
    // 277
   // 1431. Kids With the Greatest Number of Candies
   public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int count = 0;
       for(int i=0; i < flowerbed.length; i++){
           if(flowerbed[i] == 0){
               int prev = ( i == flowerbed.length - 1) ? 0: flowerbed[i-1];
               int next = ( i == 0) ? 0: flowerbed[i - 1];
               if(next == 0 && prev ==0){
                   flowerbed[i] = 1;
                   count ++;
               }
           }
       }
       return count >= n;
   }

    // Reverse Vowels
    // https://www.youtube.com/watch?v=eU5ulIEF3dw
    // https://www.youtube.com/watch?v=94RdOzbXvHM
    // https://www.youtube.com/watch?v=Vc4nQa0e2n4
    public String reverseVowels(String s) {
        int  start =0, end = s.length() - 1, n = s.length();
        char ch[] = s.toCharArray();
        while(start < end ){
            if(!isVowel(ch[start])){
                start++;
            } else if(!isVowel(ch[end])){
                end --;
            }else {
                swap(ch, start, end);
                start ++;
                end --;

            }
        }
        return new String(ch);
    }

    public void swap(char[] ch, int start , int end){
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
    }

    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O'||ch == 'U';
    }

    // https://www.youtube.com/watch?v=tX-ZcKTNwYk
    public String reverseWords(String s) {
        String[] words= s.trim().split("\\s+");
        String out ="";

        for(int i = words.length -1; i> 0; i--){
            out += words[i]+" ";
        }
        return out + words[0];
    }


        // https://www.youtube.com/watch?v=yEFlGWOVH8g
        // https://www.youtube.com/watch?v=BWD9ZHvhihk
        public boolean increasingTriplet(int[] nums) {
            if(nums.length < 3) return false;
            int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
            for(int in=0; in < nums.length; in++ ){
                if(nums[in] <= i){
                    i = nums[in];
                } else if (nums[in] <= j) {
                    j = nums[in];
                } else {
                    return true;
                }
            }
            return false;
    }


    // 443. String Compression
        // https://www.youtube.com/watch?v=IhJgguNiYYk
        // https://www.youtube.com/watch?v=cNakvqTDENM
        public int compress(char[] chars) {
            int index=0, start =0;
            while(start < chars.length){
                int end = start;
                while(end < chars.length && chars[start] == chars[end]){
                    end++;
                }
                int count = end - start;
                chars[index++] = chars[start];
                if(count >=2){
                    char[] freq = Integer.toString(count).toCharArray();
                    for(char ch: freq){
                        chars[index++] = ch;
                    }
                }
                start = end;
            }
            return index;
        }

        // 26. Remove Duplicates from Sorted Array.
        public int removeDuplicates(int[] nums) {
            int j=0;
            for(int i =0; i < nums.length; i++){
                if(nums[i] != nums[j]){
                    nums[j+1] = nums[i];
                    j++;
                }
            }
            return j+1;
        }

    //
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    // 80. Remove Duplicates from Sorted Array II



   // 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE;
        int max_profit= 0;

        for (int i =0; i < prices.length; i++) {
            if(prices[i] < min_val){
                min_val = prices[i];
            }else if(prices[i] - min_val > max_profit) {
                max_profit = prices[i] - min_val;
            }
        }
        return max_profit;
    }

    // greedy algorithum
   /* public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(i>max){
                return false;
            }
            max=Math.max(max,i+nums[i]);
        }
        return true;
    }
    */

    // 55. Jump Game
    // two pointers
    public boolean canJump(int[] nums) {
        int k = nums.length-2;
        int end = nums.length-1;

        while(k>=0){
            if(k+nums[k]>=end) end=k;
            k--;
        }
        return end==0;
    }

    // 45. Jump Game II


}
