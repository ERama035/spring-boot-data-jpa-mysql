package com.bezkoder.spring.datajpa.allLeetExamples;

import java.util.Arrays;

public class MinSubArray {

    public static int minSubArrayLen(int[] nums, int target) {
        int left=0;
        int right=0;
        int sum=0;
        int res=Integer.MAX_VALUE;

        for(right=0;right< nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                res = Math.min(res,right-left +1);
                sum-=nums[left]; // not sure why we need to subtract
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0: res;
    }

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        int result = minSubArrayLen(nums, target);
        System.out.println("--- num[] :: "+ result);
    }

}