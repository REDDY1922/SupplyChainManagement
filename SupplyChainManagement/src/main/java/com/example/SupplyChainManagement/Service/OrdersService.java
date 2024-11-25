package com.example.SupplyChainManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupplyChainManagement.Models.Orders;
import com.example.SupplyChainManagement.Repository.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private WarehouseService warehouseService;
	public Orders placeOrder(String customerName, String productName, int quantity, boolean stockAvailable) {
		// TODO Auto-generated method stub
		 boolean isStockAvailable = warehouseService.checkStock(productName, quantity); // Stock check logic
		Orders order = new Orders();
        order.setCustomerName(customerName);
        order.setProductName(productName);
        order.setQuantity(quantity);
		order.setStatus(isStockAvailable ? "Confirmed" : "Out of Stock");
        return ordersRepository.save(order);
	}
	
}
