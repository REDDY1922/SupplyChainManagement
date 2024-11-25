package com.example.SupplyChainManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupplyChainManagement.Models.Shipment;
import com.example.SupplyChainManagement.Repository.ShipmentRepository;

@Service
public class TransportationService {
	@Autowired
    private ShipmentRepository shipmentRepository;

	public Shipment assignShipment(String orderId, double weight, double distance) {
		Shipment shipment = new Shipment();
        shipment.setOrderId(orderId);
        shipment.setWeight(weight);
        shipment.setDistance(distance);
        shipment.setFreightCost(calculateFreightCost(weight, distance));
        shipment.setRoute(optimizeRoute(distance));
        shipment.setStatus("In Transit");
        return shipmentRepository.save(shipment);
	}
	
	private double calculateFreightCost(double weight, double distance) {
        return (weight * 5) + (distance * 0.1);
    }

    private String optimizeRoute(double distance) {
        return distance > 500 ? "Highway" : "City Roads";
    }
}
