package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.sun.corba.se.spi.orbutil.fsm.Guard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.List;
/**
 * Created by Przemek on 2016-07-19.
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    public int addCustomer(Customer customer) {
        //language=SQL
        final String SQL_INSERT_CUSTOMER="INSERT INTO CUSTOMERS(NAME,AGE,SALARY) VALUES (?,?,?)";
        final String name = customer.getName();
        final int age = customer.getAge();
        final double salary = customer.getSalary();

        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_CUSTOMER,
                        Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,salary);
                return preparedStatement;
            }
        };

        final KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator,holder);
        return holder.getKey().intValue();
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

    @Override
    public boolean customerExists(int id) {
        //language=SQL
        String SQL_SELECT_CUSTOMER="SELECT ID FROM CUSTOMERS WHERE ID=?";
       List<Integer> list = jdbcTemplate.query(SQL_SELECT_CUSTOMER, new Object[] {id},(ResultSet result, int i)->{
           return result.getInt(1);
        });

        if(list.isEmpty()) return false;

        return true;
    }
}
