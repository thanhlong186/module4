package com.codegym.service.Impl;

import com.codegym.model.ProductType;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<ProductType> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Page<ProductType> findAllByCustomer(String name, Pageable pageable) {
        return customerRepository.findAllByNameContaining(name, pageable);
    }
}
