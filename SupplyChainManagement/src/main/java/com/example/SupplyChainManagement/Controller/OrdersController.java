package com.example.SupplyChainManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SupplyChainManagement.Service.OrdersService;
import com.example.SupplyChainManagement.Service.WarehouseService;

@RestController
@RequestMapping("/order")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private WarehouseService warehouseService;
	@PostMapping("/place")
	public String placeOrder(@RequestParam String customerName, @RequestParam String productName, @RequestParam int quantity) {
		boolean stockAvailable = warehouseService.checkAndReduceStock(productName, quantity);
        return ordersService.placeOrder(customerName, productName, quantity, stockAvailable).getStatus();
	}
}
