package com.peterpham.myfirstcrud.repositories;

import com.peterpham.myfirstcrud.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
            + " OR p.price LIKE %?1%"
            + " OR p.description LIKE %?1%")

    List<Product> search(String keyword);
}
