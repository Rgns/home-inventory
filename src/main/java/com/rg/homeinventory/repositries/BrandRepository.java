package com.rg.homeinventory.repositries;


import com.rg.homeinventory.entities.Brand;
import com.rg.homeinventory.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends MongoRepository<Brand,String> {

    public Brand findByBrandName(String brandName);
}
