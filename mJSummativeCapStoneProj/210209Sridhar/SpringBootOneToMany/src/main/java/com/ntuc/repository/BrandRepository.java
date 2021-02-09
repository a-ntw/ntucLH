package com.ntuc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntuc.model.Brands;

public interface BrandRepository extends JpaRepository<Brands, Integer> {

}
