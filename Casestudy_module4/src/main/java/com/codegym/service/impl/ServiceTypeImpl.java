package com.codegym.service.impl;

import com.codegym.model.ServiceType;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeImpl implements IServiceType {

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<ServiceType> findAllServiceType() {
        return iServiceTypeRepository.findAll();
    }
}
