package com.rg.homeinventory.repositries;


import com.rg.homeinventory.entities.InventoryDetails;
import com.rg.homeinventory.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends MongoRepository<Product,UUID> {

    public Product findByProductId(UUID productId);
    public List<Product> findByNameAndBrandNameAndCategory(String itemDetails_name, String itemDetails_brandName, String itemDetails_category);

    @Query("select p from Product p where brandName like %?1%")
    Page<Product> findByBrandName(String brandName , Pageable pageable);

}
