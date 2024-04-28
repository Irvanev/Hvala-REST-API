package org.example.hvala.controllers;

import org.example.hvala.dtos.CategoryDto;
import org.example.hvala.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    Iterable<CategoryDto> getAllCategories() {
        return categoryService.allCategories();
    }

    @PostMapping("/add")
    CategoryDto addCategory(@RequestBody CategoryDto category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/update/{id}")
    void updateCategory(@PathVariable UUID id, @RequestBody CategoryDto category) {
        categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
    }

}
