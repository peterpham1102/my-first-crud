package com.peterpham.myfirstcrud.services.impl;

import com.peterpham.myfirstcrud.domain.Supplier;
import com.peterpham.myfirstcrud.repositories.SupplierRepository;
import com.peterpham.myfirstcrud.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSupplier() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);

    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);

    }

    @Override
    public Optional<Supplier> findSupplierById(Long id) {
        return supplierRepository.findById(id);
    }
}
