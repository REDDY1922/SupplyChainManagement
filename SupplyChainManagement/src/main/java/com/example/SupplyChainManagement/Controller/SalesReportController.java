package com.example.SupplyChainManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SupplyChainManagement.Models.SalesReport;
import com.example.SupplyChainManagement.Service.SalesReportingService;

@RestController
@RequestMapping("/report")
public class SalesReportController {
	@Autowired
	private SalesReportingService salesReportingService;
	@GetMapping("/annual/{year}")
    public SalesReport generateAnnualReport(@PathVariable String year) {
        return salesReportingService.generateAnnualReport(year);
    }
}
