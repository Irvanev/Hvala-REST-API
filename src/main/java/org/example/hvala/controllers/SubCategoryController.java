package org.example.hvala.controllers;

import org.example.hvala.dtos.SubCategoryDto;
import org.example.hvala.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/sub_categories")
public class SubCategoryController {
    private SubCategoryService subCategoryService;

    @Autowired
    public void setSubCategoryService(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/all")
    Iterable<SubCategoryDto> getAllSubCategories() {
        return subCategoryService.allSubCategories();
    }

    @PostMapping("/add")
    void addSubCategory(@RequestBody SubCategoryDto addSubCategoryDto) {
        subCategoryService.addSubCategory(addSubCategoryDto);
    }

    @PutMapping("/update/{id}")
    void updateSubCategory(@PathVariable UUID id, @RequestBody SubCategoryDto subCategory) {
        subCategoryService.updateSubCategory(id, subCategory);
    }
}
