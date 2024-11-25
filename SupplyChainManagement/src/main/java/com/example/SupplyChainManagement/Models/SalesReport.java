package com.example.SupplyChainManagement.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String year;
	private double totalSales;
	private int totalOrders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	public int getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}
	@Override
	public String toString() {
		return "SalesReport [id=" + id + ", year=" + year + ", totalSales=" + totalSales + ", totalOrders="
				+ totalOrders + "]";
	}
	
}
