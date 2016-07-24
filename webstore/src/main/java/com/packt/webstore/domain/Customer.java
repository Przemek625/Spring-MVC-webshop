package com.packt.webstore.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Przemek on 2016-07-19.
 */
public class Customer{


    private int id;

    @NotNull
    @Size(min=2, max=15)
    private String name;
    @Min(value = 18)
    private int age;
    @Min(value = 1)
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
