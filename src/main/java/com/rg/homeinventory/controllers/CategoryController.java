package com.rg.homeinventory.controllers;

import com.rg.homeinventory.dto.UpdateCategory;
import com.rg.homeinventory.entities.Category;
import com.rg.homeinventory.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController  extends AbstractController {

    @Autowired
    CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> addCategory(@RequestBody @Valid Category request){
       return getResponse(categoryService.addCategory(request), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Category> updateCategory(@RequestBody @Valid UpdateCategory request){
        return getResponse(categoryService.updateCategory(request), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Category> deleteCategory(@RequestBody @Valid Category request){
        categoryService.deleteCategory(request);
        return getResponse(null, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<String>> getAllCategories(){
        return getResponse(categoryService.getCategoryList(), HttpStatus.OK);
    }
}
