package com.example.SupplyChainManagement.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupplyChainManagement.Exception.ProductNotFoundException;
import com.example.SupplyChainManagement.Models.Product;
import com.example.SupplyChainManagement.Repository.ProductRepository;

@Service
public class WarehouseService {
	@Autowired
	private ProductRepository productRepository;
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	public Product getProductByName(String name) throws ProductNotFoundException{
		Optional<Product> optional=productRepository.findByName(name);
		if(!optional.isPresent()) {
			throw new ProductNotFoundException("Product Not Found");
		}
		return optional.get();
	}
	
	public void addStock(String name, int quantity) {
		// TODO Auto-generated method stub
		Product product=productRepository.findByname(name);
		if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            productRepository.save(product);
        }
	}
	public boolean checkAndReduceStock(String name, int quantity) {
        Product product = productRepository.findByname(name);
        if (product == null || product.getQuantity() < quantity) {
            return false; // Product not available or insufficient stock
        }
        
        // Reduce stock quantity
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        return true;
    }
	public boolean checkStock(String name, int quantity) {
		// TODO Auto-generated method stub
		Product product = productRepository.findByname(name);
        if (product == null || product.getQuantity() < quantity) {
            return false; // Insufficient stock
        }
        return true;
    }
	}
	

