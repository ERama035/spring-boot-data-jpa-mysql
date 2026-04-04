package com.bezkoder.spring.datajpa.allLeetExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    public static int removeDuplicatess(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            //System.out.println("--- num[k] :: "+ nums[k-1]);
        }
        return i+1; // number of unique values
    }
    public static int removeDuplicates(int[] Array) {
        int idx = 0;
        for (int i = 0; i < Array.length; ++i) {
            if (i == 0 || Array[i] != Array[i - 1]) {
                Array[idx++] = Array[i];
            }
            // System.out.println(" --- Array[idx++] :: "+  Arrays.toString(Array));
        }
        return idx;
    }

    public static void main(String[] args) {
        int nums[] = {2,7,7,11,15};
        System.out.println("--- num[] :: "+  removeDuplicates(nums));
    }

}