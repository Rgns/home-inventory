package com.rg.homeinventory.repositries;


import com.rg.homeinventory.entities.InventoryDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface InventoryRepository  extends MongoRepository<InventoryDetails,UUID> {

    public InventoryDetails findByProductId(UUID uuid);

    Page<InventoryDetails> findByInventoryStatus(String inventoryStatus ,Pageable pageable);
}
