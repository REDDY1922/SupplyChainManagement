package com.example.SupplyChainManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupplyChainManagement.Models.SalesReport;
import com.example.SupplyChainManagement.Repository.OrdersRepository;

@Service
public class SalesReportingService {
	@Autowired
    private OrdersRepository ordersRepository;

	public SalesReport generateAnnualReport(String year) {
		int totalOrders = ordersRepository.findAll().size();
        double totalSales = ordersRepository.findAll().stream().mapToDouble(o -> o.getQuantity() * 100).sum();

        SalesReport report = new SalesReport();
        report.setYear(year);
        report.setTotalOrders(totalOrders);
        report.setTotalSales(totalSales);
        return report;
	}

}
