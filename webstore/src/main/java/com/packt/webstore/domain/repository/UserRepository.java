package com.packt.webstore.domain.repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.packt.webstore.domain.User;
import org.springframework.dao.DuplicateKeyException;

/**
 * Created by Przemek on 2016-08-03.
 */
public interface UserRepository {

    void addUser(User user) throws DuplicateKeyException;

}
