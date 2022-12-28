package com.rg.homeinventory.repositries;


import com.rg.homeinventory.entities.Item;
import com.rg.homeinventory.enums.BrandName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InventoryRepository  extends MongoRepository<Item,String> {

    public Item findByItemId(UUID uuid);

    public List<Item> findByItemDetails_NameAndItemDetails_BrandNameAndItemDetails_Category(String itemDetails_name, BrandName itemDetails_brandName, String itemDetails_category);
}
