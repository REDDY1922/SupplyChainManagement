package com.example.SupplyChainManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupplyChainManagement.Models.Return;
import com.example.SupplyChainManagement.Repository.ReturnRepository;

@Service
public class ReturnService {

	@Autowired
    private ReturnRepository returnRepository;

    @Autowired
    private WarehouseService warehouseService;

    public Return processReturn(String orderId, String productName, int quantity, String reason) {
        Return returnItem = new Return();
        returnItem.setOrderId(orderId);
        returnItem.setProductName(productName);
        returnItem.setQuantity(quantity);
        returnItem.setReason(reason);
        returnRepository.save(returnItem);

        // Update stock in warehouse
        warehouseService.addStock(productName, quantity);
        return returnItem;
    }

}
