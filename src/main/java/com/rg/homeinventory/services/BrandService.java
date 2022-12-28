package com.rg.homeinventory.services;


import com.rg.homeinventory.dto.UpdateBrand;
import com.rg.homeinventory.entities.Brand;
import com.rg.homeinventory.exceptions.ItemAlreadyAddedException;
import com.rg.homeinventory.exceptions.ItemNotFoundException;
import com.rg.homeinventory.repositries.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;


    public Brand addBrand(Brand request){
        Brand brand = brandRepository.findByBrandName(request.getBrandName());
        if(brand != null){
            throw new ItemAlreadyAddedException("Brand has already been added");
        }
       return brandRepository.save(request);
    }


    public Brand updateBrand(UpdateBrand request){
        Brand oldBrand = getBrand(request.getOldBrandName());
        deleteBrand(oldBrand);
        return brandRepository.save(new Brand(request.getNewBrandName()));
    }


    public Brand getBrand(String brand){
        return brandRepository.findByBrandName(brand);
    }

    public List<String> getBrandList(){
       // return brandRepository.findAll().stream().map(brand -> brand.getItemBrand()).collect(Collectors.toList());
        return brandRepository.findAll().stream().map(Brand::getBrandName).collect(Collectors.toList());
    }

    public void deleteBrand(Brand request){
        Brand brand = getBrand(request.getBrandName());
        if(brand == null){
            throw new ItemNotFoundException(request.getBrandName() +" Brand not found.");
        }
        brandRepository.delete(request);
    }

}
