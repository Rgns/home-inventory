package com.rg.homeinventory.controllers;

import com.rg.homeinventory.entities.Item;
import com.rg.homeinventory.entities.Product;
import com.rg.homeinventory.model.InventoryFilter;
import com.rg.homeinventory.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemController extends AbstractController{

    @Autowired
    ItemService itemService;


    @GetMapping("/filter")
    public ResponseEntity<List<Product>> getALLProductByFilter(@RequestBody InventoryFilter inventoryFilter){
        return null;

    }




    @PostMapping("/add")
    public String addItem(@RequestBody @Valid Item item){
        item.setItemId(UUID.randomUUID());
       // itemService.addItem(item);
        return "SUCCESS!!!";
    }

    @PostMapping("/update")
    public String updateItem(@RequestBody Item item){
        item.setItemId(UUID.randomUUID());
     //   itemService.updateItem(item);
        return "SUCCESS!!!";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestBody Item item){
        item.setItemId(UUID.randomUUID());
    //    itemService.deleteItem(item);
        return "SUCCESS!!!";
    }

    @PostMapping("/get")
    public String getItem(@RequestBody Item item){
        item.setItemId(UUID.randomUUID());
    //    itemService.retrieveItem(item.getItemId());
        return "SUCCESS!!!";
    }
}
