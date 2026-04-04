package com.bezkoder.spring.datajpa.current_java_interview_questions;

import java.util.*;
import java.util.stream.Collectors;

// https://gist.github.com/greekykhs/4303039a84bda3e8e809264bc12d4d3e
// https://www.javaguides.net/2023/10/sort-employee-by-name-and-salary-in-java-8.html
// https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
public class TestClass implements Runnable {


    Map<Integer, List<com.bezkoder.spring.datajpa.accounts.Employee>> sortedBySalaryGt(List<com.bezkoder.spring.datajpa.accounts.Employee> employees) {

         Map<Integer, List<com.bezkoder.spring.datajpa.accounts.Employee>> groupEmpsByDeptId =
                 employees.stream().collect(Collectors.groupingBy(com.bezkoder.spring.datajpa.accounts.Employee::getDeptId));

        Map<Integer, List<Employee>> getById = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId));

        //return employees.stream().collect(Collectors.groupingBy(Employee::getDeptId));
        return groupEmpsByDeptId;
    }



    public List<com.bezkoder.spring.datajpa.accounts.Employee> sortedBySalaryGtFt(List<com.bezkoder.spring.datajpa.accounts.Employee> employees) {

        Map<Integer, Long> datas = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));


        // filters and sorting
        List<com.bezkoder.spring.datajpa.accounts.Employee> sortedByNameAsc =
                employees.stream().filter(e -> e.getSalary() > 50000)
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());


        // get distinct employee by id
        List<Integer> ids = employees.stream().map(Employee::getDeptId).distinct().collect(Collectors.toList());
         //employees.stream().map(Employee::getDeptId).distinct().forEach(System.out::println);

        // grouping by id
        Map<Integer, Long> deptID = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));

        // average of female and female
        Map<Integer, Double> data= employees.stream().collect(Collectors.groupingBy(Employee::getEmployeeId, Collectors.averagingInt(Employee::getSalary)));



        return sortedByNameAsc;

    }

    @Override
    public void run() {
        System.out.println("Hello world");
    }

    public static void main1(int[] nums, int target) {
        //int[] nums = {1,2,3,4,5,6,7,8};
        // int target = 8;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                result.add(List.of(num, target - num));
            }
            map.put(target - num, num);
        }
        System.out.println(result);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length -1;
        while(a_pointer < b_pointer){
            if (numbers[a_pointer] + numbers[b_pointer] == target) {
                return new int[] {a_pointer+1,b_pointer+1};
            }
            else if(numbers[a_pointer] + numbers[b_pointer] > target) {
                b_pointer--;
            } else {
                a_pointer++;
            }
        }
        return new int [] {a_pointer+1,b_pointer+1};
    }

    public static void main1(String[] args) {
        /*
        Thread t = new Thread(() -> {
            System.out.println("Hello world");
        });
        t.start(); */

     /*   Thread t = new Thread(() -> {

        });
        t.run();
        */
        int[] length = new int[] {1,2,3,4,5,6,7,8};
        int target =8;
        // main1(length,target);
        System.out.println("first "+checkIfCanBreak("abc","xya") );
        System.out.println("second  "+checkIfCanBreak("abe","acd") );
        System.out.println("second  "+checkIfCanBreak("leetcodee","interview") );
    }


    public static boolean checkIfCanBreak(String s1, String s2) {
        boolean ans=check(s1,s2) || check(s2,s1);
        return ans;
    }

    private static boolean check(String s1,String s2){
        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        for(int i=0;i<str1.length;i++){

            if(str1[i] > str2[i]){
                return false;
            }

        }
        return true;
    }

    /**
     *
     *  select d.dept_name, count(e.emp_id) as emp_count
     *  from dept d
     *  left join emp e on d.dept_id = e.dept_id
     *  group by dept_name
     *  having count(e.emp_id) > 100;
     *
     *
     */



    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("straberry");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("apple");

       // fruits.addAll(fruits);
        Collections.sort(fruits);
        HashMap<String, Integer> fruitCount = new HashMap<>();

        for (String fruit : fruits){

            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);

/*         fruitCount.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
 */
            // count of elements in arraylist
            //fruitCount.forEach((fruitss, count) -> System.out.println(fruits + ": " + count));

        }

        System.out.println("Element Counts:");
        for (Map.Entry<String, Integer> entry : fruitCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}