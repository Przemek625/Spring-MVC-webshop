package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Customer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
/**
 * Created by Przemek on 2016-07-19.
 */
public interface CustomerRepository {

    @Cacheable(cacheNames = "customersCache")
    List<Customer> getAllCustomers();

    @CacheEvict(cacheNames = "customersCache",allEntries = true)
    void deleteCustomer(int id );

    @CacheEvict(cacheNames = "customersCache",allEntries = true)
    int addCustomer(Customer customer);

    @CacheEvict(cacheNames = "customersCache",allEntries = true)
    void updateCustomer(Customer customer, int id);

    boolean customerExists(int id);

}
