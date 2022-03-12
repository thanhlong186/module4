package com.thuc_hanh.province_management.service;


import com.thuc_hanh.province_management.model.Customer;
import com.thuc_hanh.province_management.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
