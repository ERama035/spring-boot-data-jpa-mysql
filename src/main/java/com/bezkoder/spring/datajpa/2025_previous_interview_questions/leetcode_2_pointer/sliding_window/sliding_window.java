package com.bezkoder.spring.datajpa.previous_interview_questions.leetcode_2_pointer.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class sliding_window {

    public static void main(String[] args) {
        //int[] array =new int[]{2,3,1,2,4,3};

       /*
        int one = minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        System.out.println("--"+one+"--");


        int stringss = lengthOfLongestSubstring("abcabcbb");
        System.out.println("--"+stringss+"--");


        int one1 = minSubArrayLen1(7, new int[]{2,3,1,2,4,3});
        System.out.println("-minSubArrayLen1-"+one1+"--");
         */


       // int one11 = minSubArrayLen11(7, new int[]{2,3,1,2,4,3});
       // System.out.println("-minSubArrayLen11-"+one11+"--");

      //  int one112 = longestSubarraySolution(new int[]{1,1,0,1});
      //  System.out.println("-minSubArrayLen11-"+one112+"--");

        int one1112 = longestSubarraySolution1(new int[]{1,1,0,1});
        System.out.println("-minSubArrayLen11-"+one1112+"--");

    }

       //Minimum Size of a Subarray Sum using sliding window
       //solution 1:
        public static int minSubArrayLen(int s, int[] nums){
            int result = Integer.MIN_VALUE;

            // here i is an index (like right pointer) and left is an pointer from first
            // sliding window starts
            int left = 0;
            int val_sum = 0;
            for(int i=0; i< nums.length;i++){
                val_sum = val_sum + nums[i]; // Subarray_Sum to a value in the window.
                // to expand the window
                while(val_sum >=s){
                    result = Math.min(result, i+1- left);  // Minimun size of subarray sum
                    val_sum = val_sum - nums[left]; // remove the element in the end of the window
                    left++;
                }
            }
            return result != Integer.MAX_VALUE ? result : 0;
        }

        //solution 2: sliding window
        public static int minSubArrayLen1(int target, int[] nums){
            int left = 0;
            int right = 0;
            int currSum = 0;
            int minLen = Integer.MAX_VALUE;
            while (right < nums.length) {
                currSum += nums[right];
                while (left <= right && currSum >= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    currSum -= nums[left++];
                }
                ++right;
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

    //solution 2: sliding window
    public static int minSubArrayLen11(int target, int[] nums){
        int left = 0;
        int currSum = 0;

        // target : 7
        // new int[]{2,3,1,2,4,3}

        int minLen = Integer.MAX_VALUE;
        for(int i=0; i< nums.length;i++){
            // current sum
            //start of the window
            currSum = currSum + nums[i];

            // 2 3 1 2 4 3
            while (currSum >= target) {
                minLen = Math.min(minLen, i - left + 1);
                // current sum
                // move the window
                // end of the window
                currSum = currSum - nums[left];
                left++;
            }
        }
        // min length value
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

        // 3. Longest Substring Without Repeating Characters
        // sliding window concept with hasset
        public static int lengthOfLongestSubstring(String s){
            int a_pointer = 0;
            int b_pointer = 0;
            int max=0;
            HashSet<Character> hash_set = new HashSet();
            while(b_pointer < s.length()){
                if(!hash_set.contains(s.charAt(b_pointer))){
                    hash_set.add(s.charAt(b_pointer));
                    b_pointer++;

                    max= Math.max(hash_set.size(), max);
                }else{
                    hash_set.remove(s.charAt(a_pointer));
                    a_pointer++;
                }
            }
            return max;
        }

    // sliding window
    // not understanding correctly
    // https://www.youtube.com/watch?v=rbf0gkN1few
    public int lengthOfLongestSubstring1(String s) {
        int left = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        // sliding window start
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                map.put(ch, right);
            } else {
                left = Math.max(left, map.get(ch) + 1);

                map.put(ch, right);
            }
            ans = Math.max(ans, right - left + 1);

        }
        return ans;
    }

    // longestSubarray
    // sliding window
    // https://www.youtube.com/watch?v=96onf64cM-U&ab_channel=PrepareYourself
    // https://www.youtube.com/watch?v=jhBrybXSFTs&ab_channel=C0deSutra
    // https://www.youtube.com/watch?v=zuMwPkI4nnU&ab_channel=CodingwithChristian
    // https://www.youtube.com/watch?v=zuMwPkI4nnU
    public static int longestSubarraySolution1(int[] nums) {

        // start of the sliding window
        int zeroCount = 0;
        int longestWindow = 0;
        int start =0;
        for(int i=0; i < nums.length; i++){
            //  zeroCount += nums[i] == 0 ? 1:0;
            if(nums[i] == 0){ // add elements of sliding window
                zeroCount++;
            }
            while(zeroCount > 1){
                //zeroCount -= nums[start] == 0 ? 1 : 0;
                if(nums[start] == 0){ // remove elements of sliding window
                    zeroCount--;
                }
                start++;
            }
            // find the value of window
            longestWindow = Math.max(longestWindow, i-start);
        }
        return longestWindow;
    }


    // 643. Maximum Average Subarray I
    // sliding window
    // https://www.youtube.com/watch?v=56TxHMG0qhQ&t=660s&ab_channel=NikhilLohia
    // https://www.youtube.com/watch?v=jS1_eAGof5U&ab_channel=EngineeringDigest
    double findMaxAverage(int[] nums, int k) {
        // Get sum for starting window
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];

        int maxSum = sum;
        // Start sliding window
        int startIndex = 0;
        int endIndex = k;
        while (endIndex < nums.length) {

            sum -= nums[startIndex]; // Remove previous element
            startIndex++;

            sum += nums[endIndex]; // Add next element
            endIndex++;

            maxSum = Math.max(maxSum, sum); // Update max sum
        }
        // Return the average
        return (double) maxSum / k;
    }

    // 643. Maximum Average Subarray I
    // solution 2: sliding window
    // https://www.youtube.com/watch?v=jS1_eAGof5U
    public double findMaxAverages(int[] nums, int k){
        // start a sliding window
        int n = nums.length;
        double ans = 0;
        double window = 0;
        // create a window by adding elements or by window starts
        for ( int i=0; i< k ; i++){
            window += nums[i];
        }
        ans = window/ k; // window average
        // window sliding starting here
        for(int right=k; right < nums.length; right++){
            window += nums[right] - nums[right - k]; // window ending point
            ans = Math.max(ans, window/k); // update max value
        }
        return ans;
    }

    // max vowels
    // leet code : 1456 : 'Maximum Number of Vowels in a Substring of Given Length
    // https://www.youtube.com/watch?v=N8mH78okcZs&ab_channel=CodingwithChristian
    public int maxVowels(String s, int k) {
        int slow = 0, fast = 0, window = 0;

        // created window size
        // Count the number of vowels in the first window
        for(fast = 0; fast < k; fast++){
            window = window + isVowel(s.charAt(fast));
        }

        int res = window;
        // slide the window based on removing the element and adding the element
        // Slide the window and update the maximum number of vowels
        while(fast < s.length()){
            window = window - isVowel(s.charAt(slow++));
            window = window + isVowel(s.charAt(fast));
            res = Math.max(window, res);
            fast++;
        }
        return res;
    }
    private int isVowel(char c){
        return (c == 'a'|| c == 'e'|| c == 'i' || c == 'o'|| c == 'u') ? 1 : 0;
    }

   // https://www.youtube.com/watch?v=FEXJGn19u7Y
    public int maxVowelss(String s, int k) {
        int maxVowels = 0;
        int windowVowels = 0;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i');
        vowels.add('o'); vowels.add('u');

        // Count the number of vowels in the first window
        for (int i = 0; i < k; i++)
            if (vowels.contains(s.charAt(i)))
                windowVowels++;

        maxVowels = windowVowels;

        // Slide the window and update the maximum number of vowels
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k)))
                windowVowels--;

            if (vowels.contains(s.charAt(i)))
                windowVowels++;

            maxVowels = Math.max(maxVowels, windowVowels);
        }

        return maxVowels;
    }


    // 485. Max Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        int current_number_of_ones =0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 1){
                current_number_of_ones += 1;
                max = Math.max(max, current_number_of_ones);
            } else{
                current_number_of_ones = 0;
            }
        }
        return max;
    }


    //1004. Max Consecutive onnes III
    public int longestOnes(int[] nums, int k) {
        int zeroCounter = 0;
        int left = 0, right = 0, n = nums.length;
        int maxLen = 0;

        while(right < nums.length){
            //Expand the window
            if(nums[right] == 0){
                zeroCounter++;
            }
            //Shrink the window ONLY if zeroCounter is bigger than k
            while(zeroCounter > k){
                if(nums[left++] == 0){
                    zeroCounter--;
                }
            }
            //update the maxLen
            maxLen = Math.max(maxLen, right - left + 1);

            //move the right pointer one to the right
            right++;
        }

        return maxLen;
    }

    //1004. Max Consecutive onnes III
    // https://www.youtube.com/watch?v=97oTiOCuxho&t=2s
    public int longestOness(int[] nums, int k) {
        int i=0, j = 0;
        while( i< nums.length){
            if(nums[i] == 0) k--;
            if(k < 0){
                if(nums[j] ==0) {
                    k++;
                }
                j++;
            }
            i++;
        }
        return i-j;
    }

    //1004. Max Consecutive onnes III
    // https://www.youtube.com/watch?v=P62mtrQE-x8
    public int longestOnesss(int[] nums, int k) {
        int left = 0,  right = 0;
        for( right=0; right < nums.length; right++){
            if(nums[right] == 0) k--;
            if(k < 0){
                if(nums[left] ==0) {
                    k++;
                }
                left++;
            }

        }
        return right-left;
    }

    // 1493. Longest Subarray of 1's After Deleting One Element
    //                         or
    // Minimum Size of a Subarray Sum using sliding window
    // https://www.youtube.com/watch?v=zuMwPkI4nnU
    public int longestSubarray(int[] nums){
        int zeroCount =0;
        int longestWindow = 0;
        int start =0;

        for(int i=0; i < nums.length; i++){
            zeroCount += nums[i] == 0 ? 1: 0;

            while(zeroCount > 1){
                zeroCount -= nums[start] == 0 ? 1: 0;
                start++;
            }

            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }

    // https://www.youtube.com/watch?v=96onf64cM-U&t=1s
    public int longestSubarrays(int[] nums){
        int prev =0, curr = 0;
        int ans =0;
        for(int i=0; i < nums.length; i++){
            if(i==1) curr++;
            else{
              ans = Math.max(ans, curr+prev);
              prev = curr;
              curr= 0;
            }
        }
        ans = Math.max(ans, curr+prev);
        return ans == nums.length? ans-1: ans;
    }

    // 30. Substring with Concatenation of All Words
    //  hard problem
    // https://leetcode.com/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150
    // https://www.youtube.com/watch?v=e8NhRcbbfl8&ab_channel=Pleasantcode
    // https://www.youtube.com/watch?v=sT0YGpefoWM&ab_channel=CodeBusters
    // https://www.youtube.com/watch?v=M0UOqHpDeQg&ab_channel=Raf%27sKaleidoscope




    // 76. Minimum Window Substring
    //  hard problem
    // https://leetcode.com/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-interview-150
    // https://www.youtube.com/watch?v=Plu192kcEmc&t=1057s&ab_channel=DeveloperDocs
    // https://www.youtube.com/watch?v=yT5nzi9f_T4&ab_channel=EricProgramming
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        //Set up the table
        for(char cur : t.toCharArray()){
            map[cur]++;
        }

        int countAllCharInT = 0;
        int left = 0, n = arr.length;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String minLenStr = "";

        while(right < n){
            //Expand the window
            map[arr[right]]--;
            if(0 <= map[arr[right]]){
                countAllCharInT++;
            }

            //Shrink the window if current window contains all the char in t
            while(countAllCharInT == t.length()){
                //Update the minLen
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    minLenStr = s.substring(left, right + 1);
                }

                //Shrink the window
                map[arr[left]]++;
                if(0 < map[arr[left]]){
                    countAllCharInT--;
                }
                left++;
            }

            right++;
        }

        return minLenStr;
    }


}

