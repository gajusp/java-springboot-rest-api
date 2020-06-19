package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
