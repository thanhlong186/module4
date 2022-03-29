package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService {
    List<CustomerType> findAllCustomerType();

    CustomerType save(CustomerType customerType);

    Optional<CustomerType> findById(Long id);

    void remove(Long id);
}
