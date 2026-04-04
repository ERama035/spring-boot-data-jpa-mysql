package com.bezkoder.spring.datajpa.corejava.lamdas;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple","orange","pineapple","berry");
        // upper case
        fruits.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                .sorted()
                .forEach(str -> System.out.println(str));

        // length :
        fruits.stream()
                .filter( f -> f.length() > 5)
                .forEach(str -> System.out.println(str));

        // remove duplicates
        fruits.stream()
                .distinct()
                .forEach(str -> System.out.println(str));

        // list of particular word
        fruits.stream().filter( str-> str.contains("berry"))
                .forEach(str-> System.out.println(str));

        // remove the element with a particaular letter
        fruits.stream().filter( str-> !str.startsWith("b"))
                .forEach(str-> System.out.println(str));

        fruits.stream().filter( str-> str.startsWith("p"))
                .findFirst();

        fruits.stream().map(str -> str.length())
                .sorted()
                .forEach(System.out::println);

        // asscending order:
        fruits.stream()
                .sorted((o1,o2) -> ((Integer)o1.length()).compareTo(o2.length())).forEach(System.out::println);

        //longest word in the list
        fruits.stream().max(Comparator.comparing(String::length));

        // get the list of string in ovels
        fruits.stream().filter(str-> str.matches(".*[aeiou].*")).forEach(System.out::println);

        // add commas and convert back to the list.
        String words = fruits.stream()
                .collect(Collectors.joining(","));

        // reverse the string in the list
        fruits.stream().map(str->new StringBuffer(str).reverse())
                        .forEach(System.out::println);

        // null check
        fruits.stream()
                .filter(str -> str!=null && str.isEmpty())
                .forEach(System.out::println);

        // Advanced:
        // group by first letter
        // emplloyee objects by name
        Map<Character, List<String>> mapwords = fruits.stream().collect(Collectors.groupingBy(str -> str.charAt(0)));
        mapwords.forEach( (key, liststr)->{
            System.out.println(key +"\t"+ liststr);
        });

        // group a list of strings by the length of the string
        fruits.stream().collect(Collectors.groupingBy(String::length))
                .forEach( (key, liststr)->{
                    System.out.println(key +"\t"+ liststr);
                });

        // using partitionby to divide into 2 lists
        Predicate<String> pred= str-> str.matches(".*[aeiou].*");
        Map<Boolean, List<String>>  mapwordss = fruits.stream().collect(Collectors.partitioningBy(pred));
        mapwordss.forEach((key, list)-> {
            System.out.println(key +"\t"+ list);
            });


        // elimnate the digits
        fruits.stream().filter(str-> !str.matches(".*[0-9].*")).forEach(System.out::println);

        // return the element and throws exception.
        String val = fruits.stream().filter(str-> str.length() > 10).findAny().orElseThrow(() -> new NoSuchElementException("no value"));
        System.out.println(val);

        // revers the elemtents
        IntStream.range(0, fruits.size()).mapToObj(i -> fruits.get(fruits.size()-1-i)).forEach(System.out::println);


        }
}
