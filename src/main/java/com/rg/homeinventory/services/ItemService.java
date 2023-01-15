package com.rg.homeinventory.services;

import com.rg.homeinventory.entities.Item;
import com.rg.homeinventory.model.InventoryFilter;
import com.rg.homeinventory.repositries.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    InventoryRepository inventoryRepository;


    @Autowired ProductService productService;

    public List<Item> getFilteredItem(InventoryFilter inventoryFilter) {

        return null;
    }

   /* public Item addItem(Item item){
        Product itemDetails = item.getItemDetails();
        if (sameItemExists(new ItemFilter(itemDetails.getName(),itemDetails.getBrandName(),itemDetails.getCategory()))){
            throw new ItemAlreadyAddedException("Item has been already Added");
        }
        item.setItemId(UUID.randomUUID());
       return inventoryRepository.save(item);
    }

    public Item updateItem(Item item){
        Item item1 = retrieveItem(item.getItemId());

        return inventoryRepository.save(item);
    }

    public Item deleteItem(Item item){
        item.setItemId(UUID.randomUUID());
        return inventoryRepository.save(item);
    }

    public Item retrieveItem(UUID uuid){
        Item item = inventoryRepository.findByItemId(uuid);
        if (item == null){
            throw new ItemNotFoundException("Item is never added to inventory");
        }
        return item;
    }

    public boolean sameItemExists(ItemFilter itemFilter){
        return 0 != inventoryRepository.findByItemDetails_NameAndItemDetails_BrandNameAndItemDetails_Category(itemFilter.getName(),itemFilter.getBrandName(),itemFilter.getItemCategory()).size();
    }

    public Item getAllItems(){

        return null;
    }*/
}
