package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);

    Employee save(Employee employee);

    Employee findById(Integer id);

    void remove(Integer id);

    Page<Employee> findByNameEmployee(String name, Pageable pageable);
}
