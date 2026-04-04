package com.bezkoder.spring.datajpa.previous_interview_questions.PractiseConceptOfTheDay;

import java.util.*;
import java.util.stream.Collectors;

public class PrUser {


    public static ArrayList<User> getUsers(){
        ArrayList<User> userList = new ArrayList<User>();

        userList.add(new User(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        userList.add(new User(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        userList.add(new User(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        userList.add(new User(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        userList.add(new User(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        userList.add(new User(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        userList.add(new User(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        userList.add(new User(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        userList.add(new User(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        userList.add(new User(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        userList.add(new User(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        userList.add(new User(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        userList.add(new User(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        userList.add(new User(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        userList.add(new User(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        userList.add(new User(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        userList.add(new User(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return userList;
    }


    public static void main(String[] args) throws Exception {
        ArrayList<User> userList = getUsers();

        // How many male and female employees are there in the organization?
        Map<String, Long> usersLists =
                userList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));

        // Print the name of all departments in the organization?
        List<String> departmentName =
                userList.stream().map(e -> e.getDepartment()).collect(Collectors.toList());

        // What is the average age of male and female employees?
        Map<String, Double> avegrageAge
                = userList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingInt(e->e.getAge())));

        // Get the details of highest paid employee in the organization?
        Optional<User> highestPayUser
                = userList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary())));

        //  Get the names of all employees who have joined after 2015?
        List<String> userListss
                = userList.stream().filter(e->e.getYearOfJoining() > 2015).map(e->e.getName()).collect(Collectors.toList());

        // Count the number of employees in each department
        Map<String, Long> departmentEmployee
                = userList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));

        // What is the average salary of each department?
        Map<String, Double> avgSalary
                = userList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(e->e.getSalary())));

        //Get the details of youngest male employee in the product development department?
        // not coming
        Optional<User> userDept
          = userList.stream().filter(e->e.getGender() == "male" && e.getDepartment() == "product development")
                    .min(Comparator.comparingLong(e->e.getAge()));

        // not coming
        // Who has the most working experience in the organization?
        Optional<User> maxSalary
        = userList.stream().sorted(Comparator.comparingDouble(e->e.getSalary())).findFirst();
        // userList.stream().sorted(Comparator.comparingInt(e-> e.getYearOfJoining())).findFirst();

        // How many male and female employees are there in the sales and marketing team?
        Map<String, Long> employeeCount
        = userList.stream()
                .filter(e->e.getDepartment() == "Sales and Marketing")
                .collect(Collectors.groupingBy(e->e.getGender(), Collectors.counting()));


        // What is the average salary of male and female employees?
        Map<String, Double> avgsalaryEmployee =
        userList.stream()
                .collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingDouble(e->e.getSalary())));

        // not coming
        // List down the names of all employees in each department?
        Map<String, List<User>> userNames
        = userList.stream()
                .collect(Collectors.groupingBy(e->e.getDepartment()));

        // What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics salary=
            userList.stream().collect(Collectors.summarizingDouble(e->e.getSalary()));

        //  Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<User>> userAgeGreater = userList.stream()
                 .collect(Collectors.partitioningBy(e -> e.getAge() > 25));
                //.collect(Collectors.groupingBy(e -> e.getAge() > 25,Collectors.toList()));

        // Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<User> oldestUser
        = userList.stream().max(Comparator.comparingLong(e->e.getAge()));


    }
}

class User {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public User(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
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
}