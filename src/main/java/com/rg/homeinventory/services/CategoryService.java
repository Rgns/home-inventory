package com.rg.homeinventory.services;


import com.rg.homeinventory.dto.UpdateCategory;
import com.rg.homeinventory.entities.Category;
import com.rg.homeinventory.exceptions.ItemAlreadyAddedException;
import com.rg.homeinventory.exceptions.ItemNotFoundException;
import com.rg.homeinventory.repositries.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Category addCategory(Category request){
        Category itemCategory = categoryRepository.findByItemCategory(request.getItemCategory());
        if(itemCategory != null){
            throw new ItemAlreadyAddedException("Category has already been added");
        }
       return categoryRepository.save(request);
    }


    public Category updateCategory(UpdateCategory request){
        Category oldCategory = getCategory(request.getOldCategory().getItemCategory());
        deleteCategory(oldCategory);
        return categoryRepository.save(request.getNewCategory());
    }


    public Category getCategory(String category){
        return categoryRepository.findByItemCategory(category);
    }

    public List<String> getCategoryList(){
        return categoryRepository.findAll().stream().map(category -> category.getItemCategory()).collect(Collectors.toList());
    }

    public void deleteCategory(Category request){
        Category category = getCategory(request.getItemCategory());
        if(category == null){
            throw new ItemNotFoundException(request.getItemCategory() +" Category not found.");
        }
        categoryRepository.delete(request);
    }

}
