package com.rg.homeinventory.services;

import com.rg.homeinventory.entities.InventoryDetails;
import com.rg.homeinventory.entities.Product;
import com.rg.homeinventory.enums.InventoryStatus;
import com.rg.homeinventory.enums.QuantityUnit;
import com.rg.homeinventory.exceptions.UnknownItemException;
import com.rg.homeinventory.repositries.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ProductService productService;

    public InventoryDetails addInventoryForProduct(InventoryDetails item){
        Product product = productService.retrieveProduct(item.getProductId());
        if(product == null){
            throw  new UnknownItemException("Provided product id is not present");
        }
       return inventoryRepository.save(item);
    }


    public InventoryDetails resetInventoryToNull(UUID productId){
        InventoryDetails inventoryDetails = getInventory(productId);
        inventoryDetails.setInventoryStatus(InventoryStatus.FINISHED);
        inventoryDetails.getQuantity().setUnit(QuantityUnit.NUM);
        inventoryDetails.getQuantity().setValue(0);
        return inventoryRepository.save(inventoryDetails);
    }

    public Page<InventoryDetails> getInventoryForProduct(UUID productId, String filter1, Integer pageSize, Integer pageNo, String sortBy,Sort.Direction sortOrder){

        //PageRequest pageRequest = new PageRequest(pageSize,pageNo, Sort.Direction.ASC,sortBy);
       return inventoryRepository.findByInventoryStatus("_",
                 PageRequest.of(pageSize,pageNo, sortOrder,sortBy));

//        InventoryDetails inventoryDetails = getInventory(productId);
//        if (inventoryDetails == null){
//            throw new ItemNotFoundException("Inventory Details not found");
//        }
//        return inventoryDetails;
    }

    private InventoryDetails getInventory(UUID productId){
        return   inventoryRepository.findByProductId(productId);

    }
}
