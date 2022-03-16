package com.codegym.phone_management.repository;

import com.codegym.phone_management.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
}
