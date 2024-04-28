package org.example.hvala.services;

import org.example.hvala.dtos.SubCategoryDto;
import java.util.UUID;

public interface SubCategoryService {
    Iterable<SubCategoryDto> allSubCategories();
    void addSubCategory(SubCategoryDto addSubCategoryDto);
    void updateSubCategory(UUID id, SubCategoryDto subCategory);
    void deleteSubCategory(UUID id);
}
