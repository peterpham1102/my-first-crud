package com.peterpham.myfirstcrud.services;



import com.peterpham.myfirstcrud.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();

    void saveProduct(Product product);

    void deleteProduct(Long id);

    Optional<Product> findProductById(Long id);


}
