package com.peterpham.myfirstcrud.repositories;

import com.peterpham.myfirstcrud.domain.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
