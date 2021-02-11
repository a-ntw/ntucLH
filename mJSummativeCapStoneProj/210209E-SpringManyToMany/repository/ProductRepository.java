package com.ntuc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntuc.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
