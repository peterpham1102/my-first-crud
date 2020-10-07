package com.peterpham.myfirstcrud.repositories;

import com.peterpham.myfirstcrud.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
