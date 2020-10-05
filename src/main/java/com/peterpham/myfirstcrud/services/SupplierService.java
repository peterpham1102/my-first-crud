package com.peterpham.myfirstcrud.services;


import com.peterpham.myfirstcrud.domain.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> getAllSupplier();

    void saveSupplier(Supplier supplier);

    void deleteSupplier(Long id);

    Optional<Supplier> findSupplierById(Long id);
}
