package com.codegym.repository;

import com.codegym.model.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
        Page<ServiceType> findAllByNameContaining(String name, Pageable pageable);
}
