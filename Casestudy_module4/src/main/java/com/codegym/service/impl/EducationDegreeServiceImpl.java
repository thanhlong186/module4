package com.codegym.service.impl;

import com.codegym.model.EducationDegree;
import com.codegym.repository.IEducationDegreeRepository;
import com.codegym.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAllEducation() {
        return educationDegreeRepository.findAll();
    }
}
