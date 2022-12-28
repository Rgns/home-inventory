package com.rg.homeinventory.controllers;

import com.rg.homeinventory.dto.UpdateBrand;
import com.rg.homeinventory.entities.Brand;
import com.rg.homeinventory.services.BrandService;
import com.rg.homeinventory.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController extends AbstractController {

    @Autowired
    BrandService brandService;

    @PostMapping()
    public ResponseEntity<Brand> addBrand(@RequestBody @Valid Brand request){
       return getResponse(brandService.addBrand(request), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Brand> updateBrand(@RequestBody @Valid UpdateBrand request){
        return getResponse(brandService.updateBrand(request), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Brand> deleteBrand(@RequestBody @Valid Brand request){
        brandService.deleteBrand(request);
        return getResponse(null, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<String>> getAllCategories(){
        return getResponse(brandService.getBrandList(), HttpStatus.OK);
    }
}
