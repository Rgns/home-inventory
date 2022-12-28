package com.rg.homeinventory.controllers;

import com.rg.homeinventory.entities.Product;
import com.rg.homeinventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController extends  AbstractController{

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product){
        product.setProductId(UUID.randomUUID());
        return getResponse(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
       return getResponse(productService.updateProduct(product), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<Product> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
        return getResponse(null, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getALLProduct(){
        return getResponse( productService.getAllProducts(), HttpStatus.OK);

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable UUID productId){
        return getResponse(  productService.retrieveProduct(productId), HttpStatus.OK);
    }
}
