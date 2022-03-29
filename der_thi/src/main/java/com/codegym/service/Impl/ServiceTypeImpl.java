package com.codegym.service.Impl;

import com.codegym.model.ServiceType;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Page<ServiceType> findAllByServiceType(String name, Pageable pageable) {
        return serviceTypeRepository.findAllByNameContaining(name, pageable);
    }


}
