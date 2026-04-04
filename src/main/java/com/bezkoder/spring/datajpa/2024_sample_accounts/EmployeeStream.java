package com.bezkoder.spring.datajpa.accounts;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStream {

    public static List<Employees> getEmployees() throws Exception {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

        Date dateOfJoining1 = dateformat.parse("17/07/1989");
        Date dateOfJoining2 = dateformat.parse("15/10/2007");
        Date dateOfJoining3 = dateformat.parse("01/10/2006");
        Date dateOfJoining4 = dateformat.parse("11/11/2005");

        List<Employees> employees=new ArrayList<>();
        employees.add(new Employees(1, "Ronalda", 5000, dateOfJoining1, 28));
        employees.add(new Employees(2, "Matilda", 7000, dateOfJoining2, 32));
        employees.add(new Employees(3, "Roslie", 10000, dateOfJoining3, 50));
        employees.add(new Employees(4, "Martha", 55000, dateOfJoining4, 60));

        return employees;
    }

    public static void main(String[] args) throws Exception {

        List<Employees> employees = getEmployees();

        //Sort the elements based on data of joining.
       List<Employees> elements = employees.stream().sorted(
                (e1,e2) -> e1.getDateOfJoining1().compareTo(e2.getDateOfJoining1())
        ).collect(Collectors.toList());
      //  elements.forEach(e->System.out.println(e.toString()));

        //Sort employees based on age
        // using method refrences
       List<Employees> methodReferences = employees.stream().sorted(
                Comparator.comparing(Employees::getAge)
        ).collect(Collectors.toList());

        // Filter employees with salary less than 8000
        List<Employees> employeeSalary = employees.stream()
                .filter( e -> e.salary < 8000)
                .collect(Collectors.toList());

        // Filter and sorted
        List<Employees> employeeSalarys= employees.stream()
                .filter( e-> e.salary > 8000)
                .sorted(Comparator.comparing(Employees::getSalary))
                .collect(Collectors.toList());

        // Find top 3 highest earning employees
        employees.stream().sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
                .limit(3)
                .map(Employees::getRonalda)
                .forEach(System.out::println);
                // .collect(Collectors.toList());

       Map<Integer, String> employeMap= employees.stream()
                .collect(Collectors.toMap(e->e.getId(), e-> e.getRonalda()));
      /*
        for (Map.Entry<Integer,String> entry: employeMap.entrySet()) {
            System.out.println(entry.getKey() + ", Stock : " + entry.getValue());
        }
      */

        //groups all Employees by age
        Map<Integer, List<Employees>> employeeGroupByAge= employees.stream()
                .collect(Collectors.groupingBy(Employees::getId, Collectors.toList()));

        for (Map.Entry<Integer,List<Employees>> entry: employeeGroupByAge.entrySet()) {
            System.out.println(entry.getKey() + ", Stock : " + entry.getValue());
        }

        // Convert into Set
        Set<String> names=
        employees.stream()
                .map(e -> e.getRonalda())
                .collect(Collectors.toSet());

        //Find average age of employee
        double averageAge = employees.stream()
                .mapToInt(e->e.getAge())
                .average().getAsDouble();

        // employee names in uppercase
       Map<String,Integer> Employee= employees.stream()
                // .map(e -> e.getRonalda())
                // .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toMap(e -> e.getRonalda().toUpperCase(), e-> e.getId()));

       // print the max salary
        employees.stream().mapToDouble(e->e.getSalary()).max().ifPresent(System.out::println);

       // average age of employee
       double age = employees.stream()
                .sorted()
                .mapToInt(e->e.getAge()).average().getAsDouble();
        System.out.println( "Avg age of employee : " + age);

        // group all employees by age
        Map<Integer, List<Employees>> employeesByAge=employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()));

       //Convert employee names into a comma seperated string
       String commaSeperated= employees.stream().map(e -> e.getRonalda())
               .collect(Collectors.joining(", ", "{", "}"));
        System.out.println( "commaSeperated : " + commaSeperated);

        //Find the youngest and oldest employee
       Employees youngest = employees.stream().min((e1,e2) -> e1.age - e2.age).orElseThrow(NoSuchElementException::new);

       Employees oldest = employees.stream().max(Comparator.comparing(e -> e.getAge())).orElseThrow(NoSuchElementException::new);

        //Increment the salary of each employee by 2000
        employees.stream()
                .peek(e->e.setSalary(e.getSalary()+2000))
                .peek(System.out::println)
                .collect(Collectors.toList());

        //Divide the employees into groups according to salary
        //is greater than 5000
        Map<Boolean, List<Employees>> employeesByGroups= employees.stream().collect(Collectors.partitioningBy( e->e.getSalary() < 5000));

    }


}