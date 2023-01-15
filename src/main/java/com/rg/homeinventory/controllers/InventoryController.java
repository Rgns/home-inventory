package com.rg.homeinventory.controllers;


import com.rg.homeinventory.entities.InventoryDetails;
import com.rg.homeinventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import static com.rg.homeinventory.utils.Constants.PAGE_CONSTANTS.*;


@RestController()
@RequestMapping("products/{productId}/inventory")
public class InventoryController extends AbstractController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping()
    public ResponseEntity<InventoryDetails> updateInventory(@RequestBody InventoryDetails inventoryDetails, @PathVariable UUID productId){
        inventoryDetails.setProductId(productId);
        return getResponse(inventoryService.addInventoryForProduct(inventoryDetails), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<InventoryDetails> resetInventory(@PathVariable UUID productId){
        return getResponse(inventoryService.resetInventoryToNull(productId), HttpStatus.OK);
    }

    @GetMapping()
    public Page<InventoryDetails> getInventory(@PathVariable UUID productId,
                                               @RequestParam Optional <Integer> pageSize,
                                               @RequestParam Optional <Integer> pageNo,
                                               @RequestParam Optional <String> filter,
                                               @RequestParam Optional <String> sortBy,
                                               @RequestParam Optional <Sort.Direction> sortOrder
    ){
        return inventoryService.getInventoryForProduct(productId, filter.orElse("_"), pageSize.orElse(DEFAULT_PAGE_SIZE), pageNo.orElse(DEFAULT_PAGE_NO),
                sortBy.orElse("id"), sortOrder.orElse(DEFAULT_SORT_ORDER));
    }



}
