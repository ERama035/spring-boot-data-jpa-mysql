package com.bezkoder.spring.datajpa.PractiseConceptOfTheDay;

import java.util.*;
import java.util.stream.Collectors;

public class PrEmployee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public PrEmployee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PrEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }
}

class PrEmployeeTest{

    static List<PrEmployee> mockData(){

        ArrayList<PrEmployee> employeeList = new ArrayList<>();
        employeeList.add(new PrEmployee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new PrEmployee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new PrEmployee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new PrEmployee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new PrEmployee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new PrEmployee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new PrEmployee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new PrEmployee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new PrEmployee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new PrEmployee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new PrEmployee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new PrEmployee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new PrEmployee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new PrEmployee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new PrEmployee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new PrEmployee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new PrEmployee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        return employeeList;
    }

    public static void main(String[] args) {
       List<PrEmployee> premployeeList = mockData();
        // premployeeList.forEach(System.out::println);

        //How many male and female employees are there in the organization?
        Map<String, Long> employeeCount = premployeeList.stream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
        for (Map.Entry<String, Long> ecount: employeeCount.entrySet()) {
            System.out.println(ecount.getKey()+":: "+ecount.getValue());
        }

        // Print the name of all departments in the organization?
        premployeeList.stream().map(e->e.getDepartment()).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //What is the average age of male and female employees?
        Map<String,Double> employeeList= premployeeList.stream().collect(Collectors.groupingBy(e->e.getGender(), Collectors.averagingInt(e->e.getAge())));

        for(Map.Entry<String,Double> emplist: employeeList.entrySet()) {
           // System.out.println(emplist.getKey()+"::"+emplist.getValue());
        }

        // Get the details of highest paid employee in the organization?
       //premployeeList.stream().max(Comparator.comparing(e->e.getSalary())).ifPresent(System.out::println);

        PrEmployee premployeeLists = premployeeList.stream().max(Comparator.comparing(e->e.getSalary())).get();
        System.out.println("list:: "+ premployeeLists.toString());

        //Get the names of all employees who have joined after 2015
        List<String> employeeName
        = premployeeList.stream().filter(e->e.getYearOfJoining() < 2015 ).map(e->e.getName()).collect(Collectors.toList());


        // Count the number of employees in each department?
        Map<String, Long> employeeLists =
                premployeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));

        for (Map.Entry<String, Long> employeeLst: employeeLists.entrySet()) {
                System.out.println(employeeLst.getValue()+" :: "+employeeLst.getKey());
        }

        // What is the average salary of each department
        Map<String, Double> salaryAvg
                = premployeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(e-> e.getSalary())));

        for (Map.Entry<String, Double> salaryAg: salaryAvg.entrySet()) {
            System.out.println(salaryAg.getValue()+" :: "+salaryAg.getKey());
        }

        //Get the details of youngest male employee in the product development department
        Optional<PrEmployee> empList = premployeeList.stream()
                .filter(e -> e.getDepartment().equals("Product Development") && e.getGender().equals("Male"))
                .min(Comparator.comparingInt(e -> e.getAge()));

        System.out.println("list of employee "+empList.toString());

        // Who has the most working experience in the organization?
        premployeeList.stream().min(
                Comparator.comparing(e->e.getYearOfJoining())
        ).ifPresent(System.out::println);

        // How many male and female employees are there in the sales and marketing team?
        Map<String,Long> teamCount= premployeeList.stream().filter(e->e.getDepartment().equals("sales and marketing")).
                collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));

        // What is the average salary of male and female employees
        Map<String,Double> avgSalary
        = premployeeList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingDouble(e->e.getSalary())));

        //  List down the names of all employees in each department
        Map<String, List<PrEmployee>> allEmp= premployeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment()));
/*
        for (Map.Entry<String, List<PrEmployee>> salaryAg: allEmp.entrySet()) {
            System.out.println(salaryAg.getValue()+" :: "+salaryAg.getKey());
        }
*/
        // What is the average salary and total salary of the whole organization
        DoubleSummaryStatistics employeeSalaryStatistics=
        premployeeList.stream().collect(Collectors.summarizingDouble(e->e.getSalary()));

        //  Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean,List<PrEmployee>> empPartationByAge
                = premployeeList.stream().collect(Collectors.partitioningBy(e->e.getAge() > 25));
        for (Map.Entry<Boolean, List<PrEmployee>> salaryAg: empPartationByAge.entrySet()) {
            System.out.println(salaryAg.getValue()+" :: "+salaryAg.getKey());
        }




    }
}