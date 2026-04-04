package com.bezkoder.spring.datajpa.leetcode_2_pointer.two_pointer;

import java.util.Arrays;

public class two_pointer_strings {

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
////////////////////////////////////////////////////////// single pointer //////////////////////////////////
    // move only zeros's' using single pointer approach
    public static void sortZero(int[] nums) {
        int index = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i= index; i< nums.length; i++){
            nums[i]=0;
        }
        System.out.println(Arrays.toString(nums));
    }

////////////////////////////////////////////////////////// two pointer //////////////////////////////////

    //sort 0 1 2
    public void sort12(int[] arr, int n){
        int start =0, end = n-1 ;

        for (int i=0; i< n  && i<= start;){
            // add 0's
            if(arr[i] == 0){
                swap(arr, start, i);
                start ++;
                i++;
            } else if (arr[i] == 2){
                swap(arr, i, end);
                end--;
            } else {
                i++;
            }
        }
    }

    // sort colors
    public static void sortColors(int[] nums) {
        int low = 0,
                mid = 0,
                high = nums.length - 1;

        while (mid <= high) {
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1 ) {
                mid++;
            } else{
                swap(nums, mid, high);
                high--;
            }
        }
    }


    // move only zeros's' using two pointer approach
    public static void moveZeros(int[] nums){
        int arr_length = nums.length, left_pointer = 0, right_pointer = 0;
        while(right_pointer < arr_length ){
            if(nums[left_pointer] != 0){ // non-zero
                left_pointer++;
                right_pointer++;
            } else if(nums[right_pointer] == 0) { // zero
                right_pointer++;
            } else{
                swap(nums, left_pointer, right_pointer);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    // simple two pointer approach
    public static void moveZeroess(int[] nums) {
        int left =0, right =0, array_length=nums.length;
        while (right < array_length) {
            if (nums[right] != 0) {
                /* int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp; */
                swap(nums, left,right);
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }

    //isSubsequence
    public static boolean isSubsequence(String s, String t){
        if(s.length() == 0) return true;

        int s_pointer = 0;
        int t_pointer = 0;

        while(t_pointer < t.length()){
            if(t.charAt(t_pointer) == s.charAt(s_pointer)) {
                s_pointer++;

                if(s_pointer == s.length()) return true;
            }
            t_pointer++;
        }

        return false;
    }


    // continer with most water
    public int maxArea(int[] height){
        int max_area =0;
        int a_pointer =0;
        int b_pointer = height.length -1;

        while(a_pointer <b_pointer){
            if(height[a_pointer] < height[b_pointer]){
                max_area = Math.max(max_area, height[a_pointer] * (b_pointer - a_pointer));
                a_pointer +=1;
            } else{
                max_area = Math.max(max_area, height[b_pointer] * (b_pointer - a_pointer));
                b_pointer -=1;
            }
        }
        return max_area;
    }


    // max number of k-sum pairs
    public int maxOperations(int[] nums, int k){
        Arrays.sort(nums);
        int count =0, left =0, right = nums.length -1;
        while(left < right){
            if(nums[left] + nums[right] == k){
              count++;
              left++;
              right--;
            } else if (nums[left]+ nums[right] < k){
                left++;
            } else{
                right--;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int[] arrayValues= new int[]{1,0,3,12,1,0,1,0};
        String[] arrayStringValues = new String[]{"flower","flow","flight"};
        int[] arrayWaterValues= new int[]{1,8,6,2,5,4,8,3,7};
        //sortZero(arrayValues);
      //  moveZeros(arrayValues);
       // moveZeroess(arrayValues);
        // isSubsequence("abcde","ace")
       // System.out.println("subsequnce : "+ isSubsequence("abc","abcde"));
        //System.out.println("longestCommonPrefix : "+longestCommonPrefix(arrayStringValues) );
        System.out.println("maxWater : "+ maxWater(arrayWaterValues) );
        //System.out.println("maxWater : "+ water(arrayWaterValues) );

    }
/********************** applying / understanding *************************/
    // 2 longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        int i=0;
        int len = strs.length;
        while(i < strs[0].length())
        {
            char ch=strs[0].charAt(i);
            System.out.println("string:: "+ch);

             for(int j=1;j<len;j++)
            {
              /*  if(strs[j].length()<=i)
                {
                    return strs[0].substring(0,i);
                }

                if(strs[j].charAt(i)! = ch)
                {
                    return strs[0].substring(0,i);
                }*/
            }

            i++;
        }
        return null;
    }

    // 2 pointers :: both start from frist
    public void moveZeroes(int[] nums) {
        int a_pointer = 0;
        // 2 pointers start from frist
        for(int b_pointer=0; b_pointer < nums.length; b_pointer++ )
        {
            // if elemetns are nonzero
            if (nums[b_pointer] != 0) {
                // swapping login
                int temp = nums[b_pointer];
                nums[b_pointer] = nums[a_pointer];
                nums[a_pointer] = temp;
                a_pointer++;
            }
        }
    }

    // 2 pointer based on length
    public static int maxAreas(int[] height){
        int a_pointer = 0 ;
        int b_pointer = height.length - 1;
        int maxArea = 0;

        while(a_pointer < b_pointer){

            int width =  Math.min(height[a_pointer], height[b_pointer]);
            int length = (b_pointer - a_pointer);
            System.out.println("length"+"::"+length+"breadth"+"::"+width);
            //area of rectangle formula : l * b
            //int currentArea = Math.min(height[a_pointer], height[b_pointer]) *  (b_pointer - a_pointer);
            int currentArea = length * width;
            maxArea = Math.max(maxArea, currentArea);

            if(height[a_pointer] < height[b_pointer]) {
                a_pointer++;
            } else {
                b_pointer--;
            }
        }
        return maxArea;
    }

    public static int maxWater(int[] height) {

        int a_pointer = 0, max_area = 0, b_pointer= height.length-1;

        while(a_pointer < b_pointer){
            int apointer = height[a_pointer];
            int bpointer = height[b_pointer];
           System.out.println("a_pointer-- "+apointer+"b_pointer-- "+bpointer);

            if(height[a_pointer] < height[b_pointer]){
                // bigger bar
                max_area = Math.max(max_area, height[a_pointer] * (b_pointer - a_pointer));
                System.out.println("----maxarea--1--"+max_area);
                a_pointer +=1;
            }else{
                // smaller bar
                max_area = Math.max(max_area, height[b_pointer] * (b_pointer - a_pointer));
                System.out.println("----maxarea--2--"+max_area);
                b_pointer -=1;
            }

        }
        return max_area;
    }


}