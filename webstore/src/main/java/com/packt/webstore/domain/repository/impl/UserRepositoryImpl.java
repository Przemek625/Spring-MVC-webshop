package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.User;
import com.packt.webstore.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 * Created by Przemek on 2016-08-03.
 */
@Repository
class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void addUser(User user) throws DuplicateKeyException {
        /*language=SQL*/
        String SQL_ADD_USER= "INSERT INTO users VALUES (?,?)";
        String username  = user.getUsername();
        String password  = user.getPassword();
        jdbcTemplate.update(SQL_ADD_USER, username, passwordEncoder.encode(password));
    }
}
