package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by Przemek on 2016-08-28.
*/
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAllProduct(){
        String hql = "from Product ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

}
