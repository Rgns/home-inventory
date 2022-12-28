package com.rg.homeinventory.repositries;


import com.rg.homeinventory.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends MongoRepository<Product,UUID> {

    public Product findByProductId(UUID productId);
    public List<Product> findByNameAndBrandNameAndCategory(String itemDetails_name, String itemDetails_brandName, String itemDetails_category);
}
