package org.example.hvala.services.Impl;

import org.example.hvala.dtos.SubCategoryDto;
import org.example.hvala.models.entities.SubCategory;
import org.example.hvala.repositories.CategoryRepository;
import org.example.hvala.repositories.SubCategoryRepository;
import org.example.hvala.services.SubCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private ModelMapper modelMapper;
    private SubCategoryRepository subCategoryRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper, SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<SubCategoryDto> allSubCategories() {
        return subCategoryRepository.findAll().stream()
                .map(subCategory -> modelMapper.map(subCategory, SubCategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addSubCategory(SubCategoryDto addSubCategoryDto) {
        SubCategory subCategory = modelMapper.map(addSubCategoryDto, SubCategory.class);
        subCategory.setCategory(categoryRepository.findByName(addSubCategoryDto.getCategory()).orElse(null));
        subCategoryRepository.saveAndFlush(subCategory);
    }

    @Override
    public void deleteSubCategory(UUID id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public void updateSubCategory(UUID id, SubCategoryDto subCategory) {
        SubCategory existingCategory = subCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("SubCategory not found"));
        existingCategory.setName(subCategory.getName());
        subCategoryRepository.save(existingCategory);
    }

}
