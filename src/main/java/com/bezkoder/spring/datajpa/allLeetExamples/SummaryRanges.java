package com.bezkoder.spring.datajpa.allLeetExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Input: nums = [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        Explanation: The ranges are:
        [0,2] --> "0->2"
        [4,5] --> "4->5"
        [7,7] --> "7"
*/
public class SummaryRanges {
    // general solution
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) { // iterating the complete array
            final int start = nums[i]; // start of array
            // compare or validate or check the second element is equal to the previous element.
            while (i+1 < nums.length &&
                   nums[i] == nums[i+1]-1) {// not understaing
                   i++; // increment the index of array.
            }
            final int end = nums[i]; // next element or end of array
            if(start == end){
                System.out.println("---start == end-- :: ");
                al.add(""+start+"");
            }else{
                System.out.println("----start !== end---- :: ");
                al.add(""+start+"->"+end+"");
            }
        }
        return al;
    }

        public static void main(String[] args){
            int num[] = {0,1,2,4,5,7};
            System.out.println("----ransomeNote---- :: "+ summaryRanges(num));

        }
}
