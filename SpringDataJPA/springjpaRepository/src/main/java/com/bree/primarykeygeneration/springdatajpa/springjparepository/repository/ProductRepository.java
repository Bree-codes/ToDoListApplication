package com.bree.primarykeygeneration.springdatajpa.springjparepository.repository;

import com.bree.primarykeygeneration.springdatajpa.springjparepository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {
}
