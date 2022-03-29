package com.codegym.service;

import com.codegym.model.Service;

import java.util.List;

public interface IService {
    List<Service> findAllService();

    Service save(Service service);
}
