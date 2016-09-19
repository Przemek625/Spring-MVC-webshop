package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by Przemek on 2016-08-28.
 */
public interface ProductRepository {

    @Cacheable("productsCache")
    List<Product> getAllProduct();
}
