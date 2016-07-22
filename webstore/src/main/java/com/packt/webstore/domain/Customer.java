package com.packt.webstore.domain;

/**
 * Created by Przemek on 2016-07-19.
 */
public class Customer{

    private int id;
    private String name;
    private int age;
    private double salary;

    public Customer(double salary, int id, String name, int age) {
        this.salary = salary;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Customer(){}


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
