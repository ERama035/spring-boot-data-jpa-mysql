package com.bezkoder.spring.datajpa.previous_interview_questions.allLeetExamples;

import java.util.Arrays;

public class MergeTwoArrays {
    public static int[] mergeArrays(int[] array1, int m, int[] array2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the merged array

        // loop through arrays
        while (i >=0 && j >=0 ){
            // find the larger elements of the 2 arrays into single large array
            if(j >= 0 && array1[i] > array2[j]){
                array1[k] = array1[i];  // copy first array
                i--;
            }else{
                array1[k] = array2[j];  // copy second array
                j--;
            }
           k--;
        }

        while (j >= 0){
            array1[k] = array2[j];
            j--;
            k--;
        }
        return array1;
    }

    public static void merge(int array1[], int m, int array2[], int n) {
        int cur = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (cur >= 0) {
            if (i < 0 || j < 0) {
                break;
            }
            if (array1[i] > array2[j]) {
                array1[cur] = array1[i--];
            } else {
                array1[cur] = array2[j--];
            }
            cur--;
        }

        // copy the left over elements in B to A.
        System.arraycopy(array2, 0, array1, 0, j + 1);
        System.out.println("--- merge sort -- :: -- "+  Arrays.toString(array1) );
        return;
    }


    public static void main(String[] args) {
        int array1[] = {1,2,3,0,0,0};
        int array2[] = {2,5,6};
        int m = 3, n = 3;
        //merge(array1, m, array2, n);
       System.out.println("--- merge sort -- :: -- "+  Arrays.toString(mergeArrays(array1, m, array2, n)));
    }


}
