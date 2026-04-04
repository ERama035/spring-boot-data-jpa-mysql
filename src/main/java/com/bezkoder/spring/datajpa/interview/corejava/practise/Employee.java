package com.bezkoder.spring.datajpa.interview.corejava.practise;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

   //https://gist.github.com/greekykhs/4303039a84bda3e8e809264bc12d4d3e
public class Employee {
    int id;
    int salary;
    String name;
    int age;
    Date dateofjoining;

    public Employee(int id, int salary, String name, int age, Date dateofjoining) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.age = age;
        this.dateofjoining = dateofjoining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(Date dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dateofjoining=" + dateofjoining +
                '}';
    }
}

class test{

    public static ArrayList<Employee> getEmployeeList() throws Exception {
        ArrayList<Employee> empList = new ArrayList<>();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfJoining1 = dateformat.parse("17/07/1989");
        Date dateOfJoining2 = dateformat.parse("15/10/2007");
        Date dateOfJoining3 = dateformat.parse("01/10/2020");
        Date dateOfJoining4 = dateformat.parse("11/11/2020");


        empList.add(new Employee(1,2000,"rama",30,dateOfJoining1));
        empList.add(new Employee(2,7000, "Matilda",32,  dateOfJoining2));
        empList.add(new Employee(3,10000, "Roslie",  50,dateOfJoining3));
        empList.add(new Employee(4, 55000,"Martha", 60,dateOfJoining4));

        return empList;
    }

    public static void main(String[] args) throws Exception {

        ArrayList<Employee> employeeList = getEmployeeList();
        //employeeList.forEach(System.out::println);

        // convert to map
        Map<Integer, Integer> employeeBySalary=
        employeeList.stream().collect(Collectors.toMap(e-> e.getId(), e-> e.getSalary()));

        // convert to set
        Set<Integer> emp= employeeList.stream().map(e-> e.getId()).collect(Collectors.toSet());
        // emp.forEach(System.out::println);

        // sort with Comparator
        //List<Employee> empList =
               employeeList.stream()
               .sorted(Comparator.comparingInt(e->e.getSalary()))
               .collect(Collectors.toList())
               //.forEach(System.out::println)
                       ;

       // sort with comparing 2 objects
        employeeList.stream().sorted(
                (e1,e2) -> e1.dateofjoining.compareTo(e2.getDateofjoining())
        ).collect(Collectors.toList())
        //        .forEach(System.out::println)
        ;

        // grouping
        Map<Boolean,List<Employee>> employeeGroup=
        employeeList.stream().collect(Collectors.groupingBy(e->e.getSalary() > 5000));

        for (Map.Entry<Boolean,List<Employee>> employeeMap: employeeGroup.entrySet()) {
           //  System.out.println(employeeMap.getKey()+" :: "+employeeMap.getValue());
        }

        Map<Boolean, List<Employee>> employeePartation = employeeList.stream()
                .collect(Collectors.partitioningBy(e-> e.getSalary() > 5000));

        for (Map.Entry<Boolean,List<Employee>> employeeMap: employeePartation.entrySet()) {
           // System.out.println(employeeMap.getKey()+" :: "+employeeMap.getValue());
        }

        // max salary and min age
        /*

        employeeList.stream().max(Comparator.comparingInt(e->e.getAge())).ifPresent(System.out::println);
        employeeList.stream().min(Comparator.comparingInt(e->e.getAge())).ifPresent(System.out::println);

        employeeList.stream().max(Comparator.comparingInt(e -> e.getSalary())).ifPresent(System.out::println);
        employeeList.stream().mapToInt(e -> e.getAge()).max().ifPresent(System.out::println);

        */

        //find top 3 highest earning employees
        employeeList.stream().mapToInt( e->e.getAge()).limit(2).forEach(System.out::println);

        //find top 3 highest earning employees
        Integer employeeHighest = employeeList.stream().mapToInt(e -> e.getSalary()).max().getAsInt();
        System.out.println("employeeHighest :: "+ employeeHighest.toString());

        // comma sapertated values
       String employeeNames= employeeList.stream().map(e->e.getName()).collect(Collectors.joining(", ", "{", "}"));
       System.out.println("employees :: "+ employeeNames.toString());

    }
}