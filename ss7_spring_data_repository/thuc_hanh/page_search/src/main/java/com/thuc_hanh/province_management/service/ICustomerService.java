package com.thuc_hanh.province_management.service;


import com.thuc_hanh.province_management.model.Customer;
import com.thuc_hanh.province_management.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
