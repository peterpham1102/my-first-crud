package com.peterpham.myfirstcrud.services;

import com.peterpham.myfirstcrud.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();

    void saveCategory(Category category);

    void deleteCategory(Long id);

    Optional<Category> findCategoryById(Long id);
}
