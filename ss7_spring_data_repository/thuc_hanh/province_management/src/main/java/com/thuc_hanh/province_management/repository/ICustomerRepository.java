package com.thuc_hanh.province_management.repository;

import com.thuc_hanh.province_management.model.Customer;
import com.thuc_hanh.province_management.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
