package com.example.SupplyChainManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SupplyChainManagement.Models.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

}
