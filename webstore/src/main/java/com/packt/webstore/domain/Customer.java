package com.packt.webstore.domain;

import org.springframework.web.multipart.MultipartFile;

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

    private MultipartFile image;


    public Customer(double salary, int id, String name, int age) {
        this.salary = salary;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Customer(int id, String name, int age, double salary, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.image = image;
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

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public MultipartFile getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (age != customer.age) return false;
        if (Double.compare(customer.salary, salary) != 0) return false;
        return name.equals(customer.name);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + age;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
