package com.techshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techshop.product.entity.Product;

public interface ProductInterface extends JpaRepository<Product, Long>{

}
