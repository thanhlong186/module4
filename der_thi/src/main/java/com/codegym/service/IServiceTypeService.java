package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.ServiceType;
import com.codegym.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAllServiceType();

    Page<ServiceType> findAllByServiceType(String name, Pageable pageable);


}
