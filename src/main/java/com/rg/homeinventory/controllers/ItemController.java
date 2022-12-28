package com.rg.homeinventory.controllers;

import com.rg.homeinventory.entities.Item;
import com.rg.homeinventory.repositries.InventoryRepository;
import com.rg.homeinventory.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;






    @PostMapping("/add")
    public String addItem(@RequestBody @Valid Item item){
        item.setItemId(UUID.randomUUID());
        itemService.addItem(item);
        return "SUCCESS!!!";
    }

    @PostMapping("/update")
    public String updateItem(@RequestBody Item item){
        item.setItemId(UUID.randomUUID());
        itemService.updateItem(item);
        return "SUCCESS!!!";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestBody Item item){
        item.setItemId(UUID.randomUUID());
        itemService.deleteItem(item);
        return "SUCCESS!!!";
    }

    @PostMapping("/get")
    public String getItem(@RequestBody Item item){
        item.setItemId(UUID.randomUUID());
        itemService.retrieveItem(item.getItemId());
        return "SUCCESS!!!";
    }
}
