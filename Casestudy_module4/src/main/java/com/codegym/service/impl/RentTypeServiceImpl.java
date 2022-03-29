package com.codegym.service.impl;

import com.codegym.model.RentType;
import com.codegym.repository.IRentTypeRepository;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAllRentType() {
        return iRentTypeRepository.findAll();
    }
}
