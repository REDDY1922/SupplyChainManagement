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
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String OrderId;
	private double weight;
	private double distance;
	private double freightCost;
	private String route;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getFreightCost() {
		return freightCost;
	}
	public void setFreightCost(double freightCost) {
		this.freightCost = freightCost;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", OrderId=" + OrderId + ", weight=" + weight + ", distance=" + distance
				+ ", freightCost=" + freightCost + ", route=" + route + ", status=" + status + "]";
	}
	
}
