package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Customer;

import java.util.List;

/**
 * Created by Przemek on 2016-07-19.
 */


public interface CustomerRepository {

    List<Customer> getAllCustomers();

    void deleteCustomer(int id );

    int addCustomer(Customer customer);

    void updateCustomer(Customer customer, int id);

}
