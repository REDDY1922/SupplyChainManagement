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
	
	public void addStock(String productName, int quantity) {
		// TODO Auto-generated method stub
		Product product=productRepository.findByname(productName);
		if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            productRepository.save(product);
        }
	}
	public boolean checkAndReduceStock(String productName, int quantity) {
        Product product = productRepository.findByProductName(productName);
        if (product == null || product.getQuantity() < quantity) {
            return false; // Product not available or insufficient stock
        }
        
        // Reduce stock quantity
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        return true;
    }
	public boolean checkStock(String productName, int quantity) {
		// TODO Auto-generated method stub
		Product product = productRepository.findByProductName(productName);
        if (product == null || product.getQuantity() < quantity) {
            return false; // Insufficient stock
        }
        return true;
    }
	}
	

