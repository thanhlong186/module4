package com.codegym.repository;

import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    Page<ProductType> findAllByNameContaining(String name, Pageable pageable);

}
