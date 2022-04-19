package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
        Page<Customer> findAllCustomer(Pageable pageable);

        Customer save(Customer customer);

        Customer findById(Long id);

        void remove(Long id);

        Page<Customer> findCustomerByCustomerName(String name, Pageable pageable);

        List<Customer> findAll();

}
