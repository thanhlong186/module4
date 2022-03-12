package com.thuc_hanh.province_management.service.impl;

import com.thuc_hanh.province_management.model.Province;
import com.thuc_hanh.province_management.repository.IProvinceRepository;
import com.thuc_hanh.province_management.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceRepository provinceRepository;


    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
            provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
            provinceRepository.deleteById(id);
    }
}
