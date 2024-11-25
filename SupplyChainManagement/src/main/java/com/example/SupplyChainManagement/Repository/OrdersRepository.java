package com.example.SupplyChainManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SupplyChainManagement.Models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
