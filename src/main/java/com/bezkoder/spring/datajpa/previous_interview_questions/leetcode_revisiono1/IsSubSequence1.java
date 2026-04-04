package com.bezkoder.spring.datajpa.previous_interview_questions.leetcode_revisiono1;

import java.util.*;
////////////////////////////////////// 2 pointer ///////////////////////////
public class IsSubSequence1 {
    // leetcode 392
    public boolean Answer(String sub, String original) {
        if(sub.isEmpty()){
            return true;
        }
        //two  pointers initilisation
        int p1 = 0, p2 = 0 ;
        // looping the strings
        while (p1 < sub.length() && p2 < original.length()) {
            // comparing the strings with points
            if(sub.charAt(p1) == original.charAt(p2)){
                    p1++;
                    p2++;
            } else {
                    p2++;
            }
        }
        // final check of the substring length
        if(p1 == sub.length()){
            return true;
        }
        return false;
    }
}
class ValidPalindrome {
    // leetcode 125
    // inout example : A man, a plan, a canal: Panama"
    public boolean isPalindrome(String s){
        // two pointer initilization
        int left = 0, right = s.length()-1;
        // looping the string
        while( left <= right){
            // comparing the string with pointers
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) { // if spaces or commas
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) { // if spaces or commas
                right--;
            } else if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            } else if (Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)){
                // incrementing the left and decrementing the right when characters are equal
                left++;
                right--;
            }
        }
        return true;
    }
}


// native queries
// Database -> informix

class squaresSortedArray {
    // leetcode 977
    public int[] sortedSquares(int[] nums){
        int size= nums.length, currs = size -1;
        int[] output= new int[size];

        // two pointer initilization
        int p1 = 0, p2 = nums.length-1;
        // looping the array
        while (p1 <= p2){
            // multiplied the values
            int tempLeft = nums[p1] * nums[p1];
            int tempRight = nums[p2] * nums[p2];
            // add to the third array after comparrision
            // sorting the array based on the left right values
            if(tempLeft > tempRight){
                output[currs] = tempLeft;
                currs--;
                p1++;
            } else {
                output[currs] = tempRight;
                currs--;
                p2--;
            }
        }
        return output;
    }
}
class removeDuplicatesFromArray {
    // solution : check side by side elements and swap the elemetns in the array
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // pointer initilization
        for (int j = 1; j < nums.length; j++) { // looping the array
            // when left and right are not same
            if (nums[j] != nums[i]) {
                i++;               // move slow pointer forward
                nums[i] = nums[j]; // overwrite duplicate with new unique number
            }
        }
        return i + 1; // new length = last unique index + 1
    }
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // pointer initilization
        int left = 0;
        int right = 1;
        // looping the array
        while (right < nums.length) {
            // when left and right are not same
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        // find the size of the array
        return left + 1;
    }
}
class trappingRainWater {
    // leetcode 42
    // height = current pointer and
    // compare the current pointer with left side or right side.
    // finally current pointer is the sum of the height
    // https://leetcode.com/problems/trapping-rain-water/description/
    public int trap(int[] height) {
        int ans =0;
        int left = 0;
        int right = height.length -1;
        while(left < right){

            if ( height[left] <= height[right] ){
                    int curr = left;
                    while ( height[++ left] < height[curr]){
                        ans += height[curr] - height[left];
                    }
            } else{
                    int curr = right;
                    while ( height[--right] < height[curr]){
                        ans += height[curr] - height[right];
                    }
            }

        }
        return ans;
    }
}

class threeSum {
    // 15
    // https://leetcode.com/problems/3sum/description/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // sort the array in-place
        Arrays.sort(nums);
        for(int i=0; i< nums.length -2;i++){
            if (i ==0 || i>0 && nums[i-1] != nums[i] ){
                int low = i+1, high = nums.length -1;
                int sum = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while( low < high && nums[low] == nums[low+1]) {
                           low++;
                        }
                        while( low < high && nums[low] == nums[high-1]) {
                           high--;
                        }
                        low++;
                        high--;
                    } else if ( nums[low] + nums[high] > sum ){
                            low++;
                    } else {
                            high--;
                    }
                }
            }
        }
        return result;
    }
}

class moveZeros{
    // leetcode 283
    public void moveZeroes(int[] nums) {
        // 2 pointers start from frist
        int left = 0, right = 0, array_length = nums.length;
        while (left < array_length) {
            if (nums[left] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right++;
            }
            left++;
        }
    }
}

class containerWithMostWater{
    // leetcode 11
    public int containerWithMostWater(int[] nums) {
        int max_area = 0;
        int a_pointer = 0;
        int b_pointer = nums.length -1;

        while(a_pointer < b_pointer ) {
            if(nums[a_pointer] < nums[b_pointer]){
                max_area = Math.max(max_area, nums[a_pointer] * (b_pointer - a_pointer));
                a_pointer += 1;
            } else {
                max_area = Math.max(max_area, nums[b_pointer] * (b_pointer - a_pointer));
                b_pointer -= 1;
            }
        }
        return max_area;
    }
}

class sumKpairs{
    // leetcode 1679
    public int sumKpairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0, left=0, right = nums.length -1;
        while(left < right){
            if (nums[left] + nums[right] == k){
                left++;
                right--;
                count++;
            } else if (nums[left] + nums[right] < k){
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}

////////////////////////////////////////////////////////////////

class reverseString {
    public void reverseString(char[] s) {
    int left = 0, right = s.length -1; // initilzation of pointers
     while( left < right){ // looping the characters
        if(left != right ){
            // // swap left to right
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            // increase the pointers
            left++;
            right--;
        } else {
            // increase the pointers
            left++;
            right--;
        }
     }
    }

    public void reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
            // swap an array
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }
}
class reverseWords {
    public String reverseWords(String s) {
        StringBuffer sb= new StringBuffer();
        int i = s.length()-1;
        while (i >= 0){
            if(s.charAt(i) == ' '){
                i--;
            } else {
                int j = i;
                // loop the string without ' '
                while (i >= 0 && s.charAt(i) != ' '){
                    i--;
                }
                if(sb.length() > 0){ // add space after word
                    sb.append(' ');
                }
                for(int k =i+1;k <=j;k++){
                    sb.append(s.charAt(k));
                }
            }

        }
        return sb.toString();
    }
    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;

        while (right >= 0) {
            // 1️⃣ Skip trailing spaces
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            if (right < 0) break; // no more words

            // 2️⃣ Find the start of the current word
            int left = right;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }

            // 3️⃣ Append the word
            if (sb.length() > 0) sb.append(' ');

            sb.append(s.substring(left + 1, right + 1));

            // 4️⃣ Move `right` to before this word
            right = left - 1;
        }

        return sb.toString();
    }
}
class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length ; i++) {

            while(strs[i].indexOf(prefix) !=0 ){

                prefix = prefix.substring(0,prefix.length()-1);

                if(prefix.isEmpty() ) return "";
            }

        }
        return prefix;
    }
    // need to try this
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String pref = strs[0];
        int prefLen = pref.length();

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (prefLen > s.length() || !pref.equals(s.substring(0, prefLen))) {
                prefLen--;
                if (prefLen == 0) {
                    return "";
                }
                pref = pref.substring(0, prefLen);
            }
        }
        return pref;
    }
}
// 52
class lengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // initilizate the pointers
        int left = 0;
        int ans = 0;

        for(int right = 0; right < s.length(); right++){ // sliding window length
            char ch = s.charAt(right);
            // check the character in map and update
            if(!map.containsKey(ch)){
                map.put(ch, right);
            } else {
                // check the character already in map and update left pointer
                left = Math.max(left, map.get(ch) +1 );
                map.put(ch, right);
            }
            ans = Math.max(ans, right- left +1);
        }
        return ans;
    }
}
// 53
class characterReplacement {
    public int characterReplacement(String s) {
        int left = 0;
        int ans = 0;


        return ans;
    }
}


// 59
class longestPalindromeSubstring {
    public int longestPalindromeSubstring(String s) {
         int left = 0;
        int ans = 0;


        return ans;
    }
}

// note : when we encounter paranthesis problems
// solutions : these problems are done by stacks
class ValidParentheses {

    public boolean isValid(String s) {
        // set of map values
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        // taken stack for check the paraentheses
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            // compare the value of char and find to remove the value from the stack
            if(map.containsKey(curr)){
                // if stack contains value as below.
                // char pop = stack.size() != 0 ? stack.pop() : '#';
                char pop;
                if (!stack.isEmpty()) {
                    pop = stack.pop();
                } else {
                    pop = '#';
                }
                if(pop != map.get(curr)){
                    return false;
                }
            } else {
                // compare the value of char and push the value to the stack
                stack.push(curr);
            }
        }
        return false;
    }


    public boolean isValid2(String s) {
        // set of map values
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        // taken stack for check the paraentheses

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                char pop;
                if (!stack.isEmpty()) {
                    pop = stack.pop();
                } else {
                    pop = '#';
                }
                if (pop != map.get(curr)) {
                    return false;
                }
            } else{
                stack.push(curr);
            }
        }
        return stack.isEmpty();
    }
}

class decodeString {
    public boolean decodeString(String s) {


    return false;
    }

}