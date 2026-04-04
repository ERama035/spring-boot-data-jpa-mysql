package com.bezkoder.spring.datajpa.previous_interview_questions.PractiseConceptOfTheDay;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciSeq {

    public static void main1(String[] args) {
        int n=10;
        int firstNum=0;
        int secNum=1;
        System.out.println("Fibonacci series till"+ n+"terms");

        for(int i=0; i<=n; i++){
            System.out.print(firstNum+ "-");
            int nextTerm=firstNum+secNum;
            firstNum=secNum;
            secNum=nextTerm;
        }
    }
    public static void main(String[] args) {
        int n=10;
        int firstNum=0;
        int secNum=1;
        // febnoique series
        for(int i=0; i >= n; i++){
            System.out.println("numbers" + i);
            int febnum= firstNum + secNum; // add fist and sec
            firstNum = secNum; // replace 2nd in 1st.
            secNum = febnum; // replace secnd in first.
        }
    }
}

class printAllArrayElements{
    public static void main(String[] args) {
        String [] arr= {"one","Two","Three"};

        Arrays.asList(arr).forEach(System.out::println);

        Arrays.stream(arr).forEach(e -> System.out.println(e));

        Stream.of(arr).forEach(element -> System.out.println(element));

        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i]);
        }

        for(String e: arr){
            System.out.println("element 5 ::"+e);
        }

        System.out.println(Arrays.toString(arr));

        String resultss = Arrays.stream(arr).sorted().collect(Collectors.toList()).toString();
        System.out.println("last method :: "+resultss);

        String arrayCollector = Arrays.stream(arr).sorted().collect(Collectors.joining(", ")).toString();
        System.out.println(" 7th method :: "+arrayCollector);
    }

}
class CountWordsUsingJava8{
    public static void main(String[] args) {
        String str = "Iam learning java";
        Long strCount= Arrays.stream(str.split("\\s+")).count();
        System.out.print("count :: "+strCount);
        System.out.println("Count Number Of Words::"+ countNumberOfWords(str));
    }
    private static Integer countNumberOfWords(String s){
        int count=0;
        if(s.charAt(0) != ' '){
            count++;
        }
        // example: Iam learning java
        for (int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ' && s.charAt(i+1) != ' '){
                count++;
            }
        }
        return count;
    }
}

class removingDuplicatesJava8{
    public static void main(String[] args) {


    }
    private static String removingDuplicatesJava(String s){

        return null;
    }
}

class MedianArray{

    // did not understand.
    public static void main(String[] args) {
        int[] array = {12,4,5,9,8,6};
        double median = findMedian(array);
        System.out.println("median :: "+median);
    }


    public static double findMedian(int[] array){
        Arrays.sort(array);
        int n = array.length;
         if(n%2==1) {
             return array[n/2];
         } else {
            return ( array[n-1]/2 + array[n/2] )/ 2.0;
         }
    }

}


class PrintAlternateNumbersArray{


    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        // Arrays.stream(array).filter(i-> i%2 ==0).map( i-> array[i]).forEach(System.out::println);
        // Arrays.stream(array);
        // List<int[]> res = Arrays.asList(array);

         IntStream.range(0,array.length).filter( i -> i%2 == 0).map(i->array[i]).forEach(System.out::println);
        // int[] res = Arrays.stream(array).filter(a -> a % 2 == 0).toArray();

    }
}

class PalindromeNumber {


    public static void main(String[] args) {
        int num = 123456789;
        System.out.println("palindrome with number :: "+palindrome(num));
        System.out.println("palindrome with string:: "+palindromeJava8("oneee") );
        System.out.println("palindrome with java :: "+palindromeJava("oneee") );

    }

    static Boolean palindrome(int num){
        String original= String.valueOf(num);
        String reversed = IntStream.rangeClosed(1,original.length())
                          .mapToObj(i-> original.charAt(original.length()-i))
                          .collect(StringBuilder::new, StringBuilder::append,StringBuilder::append)
                          .toString();

    return original.equals(reversed);
    }

    static Boolean palindromeJava8(String str){
        int bp=str.length()-1;
        Boolean palindrome= IntStream.range(0,str.length())
                .allMatch(i -> str.charAt(i) == str.charAt(bp -i));
        return palindrome;
    }

    static Boolean palindromeJava(String str){
    boolean result = false;
    int fp=0, bp=str.length()-1;
        while(fp<str.length()/2){
            if(str.charAt(fp) == str.charAt(bp)){
                result = true;
                fp++;
                bp--;
            } else{
                return false;
            }
        }
     return result;
    }

}

class Anagram {

    public static void main(String[] args) {
        System.out.println("anagram checker:: "+anagramCheckerForStrings("one","one"));
        System.out.println("anagram checker:: "+anagramCheckerForStringsJava8("one","one"));
    }

    static Boolean anagramCheckerForStrings(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        str1 = str1.toLowerCase();
        str2= str2.toLowerCase();

        Map<Character, Integer> map1= getCharacterCountMap(str1);
        Map<Character, Integer> map2= getCharacterCountMap(str2);

        return map1.equals(map2);
    }

    private static Map<Character,Integer> getCharacterCountMap(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put( c, map.getOrDefault(c,0)+1);
        }
        return map;
    }

    private static boolean anagramCheckerForStringsJava8(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }

        String sortedStr1 = str1.toLowerCase().chars().sorted().
                collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append).toString();

        String sortedStr2 = str2.toLowerCase().chars().sorted().
                collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append).toString();

        return sortedStr1.equals(sortedStr2);
    }
}

class StringReverse{

    public static void main(String[] args) {
        String str= "Welcome to java world";
        String splitArray[] = str.split(" ");
        for (int i= splitArray.length -1; i> 0;i--){
            System.out.println(splitArray[i]);
        }
    }
}
