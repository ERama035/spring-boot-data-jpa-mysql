package com.bezkoder.spring.datajpa.accounts;

import java.util.Date;


public class Employees {
    int id;
    String ronalda;
    int salary;

    Date dateOfJoining1;
    int age;

    public Employees(int id, String ronalda, int salary, Date dateOfJoining1, int age) {
        this.id = id;
        this.ronalda = ronalda;
        this.salary = salary;
        this.dateOfJoining1 = dateOfJoining1;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRonalda() {
        return ronalda;
    }

    public void setRonalda(String ronalda) {
        this.ronalda = ronalda;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateOfJoining1() {
        return dateOfJoining1;
    }

    public void setDateOfJoining1(Date dateOfJoining1) {
        this.dateOfJoining1 = dateOfJoining1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", ronalda='" + ronalda + '\'' +
                ", salary=" + salary +
                ", dateOfJoining1=" + dateOfJoining1 +
                ", age=" + age +
                '}';
    }


}
