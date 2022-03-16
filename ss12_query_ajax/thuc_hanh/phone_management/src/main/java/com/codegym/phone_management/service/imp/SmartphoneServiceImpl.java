package com.codegym.phone_management.service.imp;

import com.codegym.phone_management.model.SmartPhone;
import com.codegym.phone_management.repository.ISmartPhoneRepository;
import com.codegym.phone_management.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartphoneServiceImpl implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
