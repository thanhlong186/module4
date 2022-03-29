package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
}
