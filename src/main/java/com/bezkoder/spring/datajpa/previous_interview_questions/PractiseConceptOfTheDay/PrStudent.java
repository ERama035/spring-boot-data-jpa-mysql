package com.bezkoder.spring.datajpa.previous_interview_questions.PractiseConceptOfTheDay;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrStudent {

    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public PrStudent(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
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
        return "PrStudent{" +
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


class Institute{
    String name;

    List<String> locations;
    public Institute(String name, List<String> locations)
    {
        this.name = name;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                ", locations=" + locations +
                '}';
    }
}

class PrStudentTest{

    public static ArrayList<PrStudent> getStudentList() throws Exception{
        ArrayList<PrStudent> PrStudentList = new ArrayList<PrStudent>();

        PrStudentList.add(new PrStudent(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        PrStudentList.add(new PrStudent(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        PrStudentList.add(new PrStudent(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        PrStudentList.add(new PrStudent(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        PrStudentList.add(new PrStudent(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        PrStudentList.add(new PrStudent(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        PrStudentList.add(new PrStudent(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        PrStudentList.add(new PrStudent(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        PrStudentList.add(new PrStudent(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        PrStudentList.add(new PrStudent(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        PrStudentList.add(new PrStudent(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        PrStudentList.add(new PrStudent(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        PrStudentList.add(new PrStudent(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        PrStudentList.add(new PrStudent(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        PrStudentList.add(new PrStudent(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        PrStudentList.add(new PrStudent(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        PrStudentList.add(new PrStudent(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return  PrStudentList;
    }

    private static ArrayList<Institute> getInstituteList() throws Exception{
        ArrayList<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        return instituteList;
    }

    public static void main(String[] args) throws Exception{
        ArrayList<PrStudent> studentList = getStudentList();
        ArrayList<Institute> instituteList = getInstituteList();

       // studentList.stream().collect(Collectors.toList()).forEach(System.out::println);

        Map<Integer, String> collectTomap= studentList.stream().collect(Collectors.toMap(e->e.getId(), e->e.getName()));
       /* for(Map.Entry<Integer,String> maps: collectTomap.entrySet()){
            System.out.println("maps:: "+maps.getKey()+" key"+maps.getValue());

        }*/

        // How many male and female employees are there in the organization?
        Map<String,Long> employeeCount
        = studentList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));

        //Print the name of all departments in the organization?
        List<String> departments = studentList.stream().map(e->e.getDepartment()).collect(Collectors.toList());

        // What is the average age of male and female employees?
        Map<String,Double> studentLists
        = studentList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingInt(e->e.getAge())));

        //  Get the names of all employees who have joined after 2015
        Map<Integer,String> studentsLists
        = studentList.stream().filter(e->e.getYearOfJoining() > 2015).collect(Collectors.toMap(e->e.getId(),e->e.getName()));

        // Count the number of employees in each department?
        Map<String,Long> employeeCounts
        = studentList.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.counting()));

        // What is the average salary of each department?
        Map<String, Double> avgSalary =
        studentList.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.averagingDouble(e->e.getSalary())));

        // not coming
        //  Get the details of youngest male employee in the product development department?
        Optional<PrStudent> student = studentList.stream()
                .filter(e->e.getGender() == "Male" && e.getDepartment() =="product development")
                .min(Comparator.comparingInt(e->e.getAge()));
                // .min(Collectors.groupingBy());

        // not coming
        // Get the details of highest paid employee in the organization?
        Optional<PrStudent> highestSalary
                = studentList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary())));

        // not coming
        // Who has the most working experience in the organization?
        Optional<PrStudent> workExp = studentList.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(e->e.getYearOfJoining())));

        //
        List<PrStudent> studentexp = studentList.stream().
                sorted(Comparator.comparingInt(e -> e.getYearOfJoining())).collect(Collectors.toList());

        // How many male and female employees are there in the sales and marketing team?
        Map<String,Long> deptGender = studentList.stream()
                .filter(e->e.getDepartment() == "sales and marketing")
                .collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));

        // What is the average salary of male and female employees?
        Map<String, Double> genderBySalary
        = studentList.stream().collect(Collectors.groupingBy(e->e.getGender(),
                Collectors.averagingDouble(e->e.getSalary())));

        // List down the names of all employees in each department
        Map<String,List<PrStudent>> allEmployees
        = studentList.stream().collect(Collectors.groupingBy(e->e.getDepartment()));

        // What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics sumofTotal
        = studentList.stream().collect(Collectors.summarizingDouble(PrStudent::getSalary));

        //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean,List<PrStudent>> prStudent
        = studentList.stream().collect(Collectors.partitioningBy(e->e.getAge() > 25));

        // Who is the oldest employee in the organization? What is his age and which department he belongs to
        Optional<PrStudent> studentListss
        = studentList.stream().max(Comparator.comparingInt(e->e.getAge()));


        // list of all Institutes
        List<String> instituteLists = instituteList.stream()
                .map(e->e.getName())
                .collect(Collectors.toList());

        instituteLists.forEach(System.out::println);

       // flat map
        Set<String> institueString
        = instituteList.stream().flatMap(i -> i.getLocations().stream()).collect(Collectors.toSet());
        institueString.forEach(System.out::println);


    }
}