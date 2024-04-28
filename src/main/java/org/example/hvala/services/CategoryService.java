package org.example.hvala.services;

import org.example.hvala.dtos.CategoryDto;

import java.util.UUID;

public interface CategoryService {
    Iterable<CategoryDto> allCategories();
    CategoryDto addCategory(CategoryDto categories);
    void updateCategory(UUID id, CategoryDto category);
    void deleteCategory(UUID id);
}
