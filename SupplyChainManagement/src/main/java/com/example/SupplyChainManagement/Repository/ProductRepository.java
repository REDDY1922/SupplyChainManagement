package com.example.SupplyChainManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SupplyChainManagement.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Optional<Product> findByName(String name);

	Product findByname(String productName);

	Product findByProductName(String productName);

}
