package com.example.SupplyChainManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SupplyChainManagement.Service.ReturnService;

@RestController
@RequestMapping("/return")
public class ReturnController {
	 @Autowired
	    private ReturnService returnService;

	    @PostMapping("/process")
	    public String processReturn(@RequestParam String orderId, @RequestParam String productName, @RequestParam int quantity, @RequestParam String reason) {
	        returnService.processReturn(orderId, productName, quantity, reason);
	        return "Return processed successfully.";
	    }
}
