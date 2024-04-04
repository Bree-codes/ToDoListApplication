package com.bree.primarykeygeneration.springdatajpa.springjparepository.repository;

import com.bree.primarykeygeneration.springdatajpa.springjparepository.entity.Product;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
/*@DataJpaTest*/

class ProductRepositoryTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setActive(true);
        product.setDescription("Made in Kenya");
        /*product.setId(1011L);*/
        product.setPrice(new BigDecimal(100));
        product.setSku("100AK");
        product.setImageUrl("image.png");
        product.setName("Text Book");


        //save product
        Product savedObject = productRepository.save(product);
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }
}