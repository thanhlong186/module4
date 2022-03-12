package com.thuc_hanh.province_management.service.impl;


import com.thuc_hanh.province_management.model.Customer;
import com.thuc_hanh.province_management.model.Province;
import com.thuc_hanh.province_management.repository.ICustomerRepository;
import com.thuc_hanh.province_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
            customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}
