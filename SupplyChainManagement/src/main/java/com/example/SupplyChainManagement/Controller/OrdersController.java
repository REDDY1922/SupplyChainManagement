package com.example.SupplyChainManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SupplyChainManagement.DTO.OrderRequest;
import com.example.SupplyChainManagement.Models.Orders;
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
	    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest request) {
	        boolean stockAvailable = warehouseService.checkAndReduceStock(request.getProductName(), request.getQuantity());
	        Orders order = ordersService.placeOrder(request.getCustomerName(), request.getProductName(), request.getQuantity(), stockAvailable);
	        return ResponseEntity.ok(order.getStatus());
	    }
	@GetMapping("/status/{id}")
    public String getOrderStatus(@PathVariable int id) {
        Orders order = ordersService.getOrderStatus(id);
        return order != null ? "Order Status: " + order.getStatus() : "Order not found.";
    }
}
