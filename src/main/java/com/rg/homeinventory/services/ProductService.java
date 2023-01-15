package com.rg.homeinventory.services;

import com.rg.homeinventory.entities.Brand;
import com.rg.homeinventory.entities.Category;
import com.rg.homeinventory.entities.Product;
import com.rg.homeinventory.exceptions.ItemAlreadyAddedException;
import com.rg.homeinventory.exceptions.ItemNotFoundException;
import com.rg.homeinventory.exceptions.UnknownItemException;
import com.rg.homeinventory.model.ProductFilter;
import com.rg.homeinventory.repositries.BrandRepository;
import com.rg.homeinventory.repositries.CategoryRepository;
import com.rg.homeinventory.repositries.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    public Product addProduct(Product product){
        if (sameProductExists(new ProductFilter(product.getName(),product.getBrandName(),product.getCategory()))){
            throw new ItemAlreadyAddedException("Product has been already Added");
        }

        Brand brand = brandService.getBrand(product.getBrandName());
        if(brand == null){
            throw new UnknownItemException("Please select from existing List or first add brand Name");
        }

        Category category = categoryService.getCategory(product.getCategory());
        if(category == null){
            throw new UnknownItemException("Please select from existing List or first add category");
        }

        product.setProductId(UUID.randomUUID());
       return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        Product oldProduct = retrieveProduct(product.getProductId());
        if(oldProduct == null){
            throw new ItemNotFoundException("This is a new product");
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Product product){
         productRepository.delete(product);
    }

    public Product retrieveProduct(UUID uuid){
        Product product = productRepository.findByProductId(uuid);
        if (product == null){
            throw new ItemNotFoundException("Product is never added to inventory");
        }
        return product;
    }

    public boolean sameProductExists(ProductFilter productFilter){
        return 0 != productRepository.findByNameAndBrandNameAndCategory(productFilter.getName(),productFilter.getBrandName(),productFilter.getItemCategory()).size();
    }

    public Page<Product> getAllProducts(String filter1, Integer pageSize, Integer pageNo, String sortBy){
       // return productRepository.findAll();

        return productRepository.findByBrandName(filter1, PageRequest.of(pageNo,pageSize, Sort.Direction.ASC,sortBy));
    }
}
