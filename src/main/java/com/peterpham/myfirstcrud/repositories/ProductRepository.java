package com.peterpham.myfirstcrud.repositories;

import com.peterpham.myfirstcrud.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
