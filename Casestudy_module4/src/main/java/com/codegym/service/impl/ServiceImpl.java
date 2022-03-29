package com.codegym.service.impl;

import com.codegym.model.Service;
import com.codegym.repository.IServiceRepository;
import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImpl implements IService {

    @Autowired
    private
    IServiceRepository iServiceRepository;
    @Override

    public List<Service> findAllService() {
        return iServiceRepository.findAll();
    }

    @Override
    public Service save(Service service) {
        return iServiceRepository.save(service);
    }
}
