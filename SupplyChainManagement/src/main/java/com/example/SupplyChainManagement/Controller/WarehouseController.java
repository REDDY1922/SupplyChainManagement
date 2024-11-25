package com.example.SupplyChainManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SupplyChainManagement.Exception.ProductNotFoundException;
import com.example.SupplyChainManagement.Models.Product;
import com.example.SupplyChainManagement.Service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		warehouseService.addProduct(product);
		return "Product added Successfully";
	}
	@GetMapping("/product/{name}")
	public ResponseEntity<?> checkProductStock(@PathVariable String name) {
		try {
			warehouseService.getProductByName(name);
			return ResponseEntity.ok().body("Product Available");
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PutMapping("/updateStock")
	public String updateStock(@RequestParam String ProductName,@RequestParam int quantity) {
		warehouseService.addStock(ProductName,quantity);
		return "Stock Updated Successfully";
	}
}

