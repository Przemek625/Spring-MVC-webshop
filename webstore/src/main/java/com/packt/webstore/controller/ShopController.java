package com.packt.webstore.controller;

import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.inject.Inject;
/**
 * Created by Przemek on 2016-09-21.
 */
@Controller
public class ShopController{

    @Inject
    private ProductRepository productRepository;

        @RequestMapping("/products")
        public String showProducts(Model model){
            model.addAttribute("products",productRepository.getAllProduct());
            return "products";
        }
}
