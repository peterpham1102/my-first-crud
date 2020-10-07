package com.peterpham.myfirstcrud.repositories;

import com.peterpham.myfirstcrud.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
