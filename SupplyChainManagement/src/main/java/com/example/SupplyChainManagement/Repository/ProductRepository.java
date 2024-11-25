package com.example.SupplyChainManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SupplyChainManagement.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
