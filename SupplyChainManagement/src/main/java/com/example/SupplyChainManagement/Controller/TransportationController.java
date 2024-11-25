package com.example.SupplyChainManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SupplyChainManagement.Models.Shipment;
import com.example.SupplyChainManagement.Service.TransportationService;

@RestController
@RequestMapping("/transport")
public class TransportationController {
	
	 @Autowired
	    private TransportationService transportationService;

	    @PostMapping("/assignShipment")
	    public Shipment assignShipment(@RequestParam String orderId, @RequestParam double weight, @RequestParam double distance) {
	        return transportationService.assignShipment(orderId, weight, distance);
	    }
}
