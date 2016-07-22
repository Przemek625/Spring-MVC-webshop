package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Przemek on 2016-07-19.
 */

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{



    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl() {
    }

    @Override
    public List<Customer> getAllCustomers() {
        /*language=SQL*/
        String SQL_SELECT_CUSTOMERS ="SELECT * from CUSTOMERS";
        List<Customer> customers= jdbcTemplate.query(SQL_SELECT_CUSTOMERS, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setAge(resultSet.getInt(3));
                customer.setSalary(resultSet.getDouble(4));
                return customer;
            }
        });

        return customers;
    }

    @Override
    public void deleteCustomer(int id) {
        //language=SQL
        String SQL_DELETE="DELETE FROM CUSTOMERS WHERE ID=?";

        jdbcTemplate.update(SQL_DELETE,id);
    }

    @Override
    public void addCustomer(Customer customer) {
        //language=SQL
        String SQL_INSERT_CUSTOMER="INSERT INTO CUSTOMERS(NAME,AGE,SALARY) VALUES (?,?,?)";

        String name = customer.getName();
        int age = customer.getAge();
        double salary = customer.getSalary();

        jdbcTemplate.update(SQL_INSERT_CUSTOMER,name,age,salary);
    }

    @Override
    public void updateCustomer(Customer customer, int id){
        //language=SQL
        String SQL_UPDATE_CUSTOMER="UPDATE CUSTOMERS SET NAME=?,AGE=?,SALARY=? WHERE ID=?";

        String name = customer.getName();
        int age = customer.getAge();
        double salary = customer.getSalary();

        jdbcTemplate.update(SQL_UPDATE_CUSTOMER,name,age,salary,id);
    }
}
