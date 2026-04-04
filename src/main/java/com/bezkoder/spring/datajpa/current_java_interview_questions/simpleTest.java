package com.bezkoder.spring.datajpa.current_java_interview_questions;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class simpleTest {


    public class MyClass {
        public static void main(String args[]) {
            int[] numbers1 = {5, 3, 8, 1, 2};
            int[] numbers2 = {5, 3, 8, 1, 2, 10, 11};
            // [1, 2, 3, 5, 8]
            Arrays.sort(numbers1);
            Arrays.sort(numbers2);
            System.out.println(Arrays.toString(numbers1)+""+Arrays.toString(numbers2));

            //  merge with anoter array
             int[] contactArrays = IntStream.concat(Arrays.stream(numbers1), Arrays.stream(numbers2)).toArray();
             System.out.println(Arrays.toString(contactArrays));

             // remove duplicates
             int[] removeDup= Arrays.stream(contactArrays).distinct().toArray();
            System.out.println(Arrays.toString(removeDup));

        }
    }
}
