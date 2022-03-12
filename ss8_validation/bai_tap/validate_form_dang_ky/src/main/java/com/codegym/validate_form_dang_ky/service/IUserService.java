package com.codegym.validate_form_dang_ky.service;

import com.codegym.validate_form_dang_ky.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void save(User user);


}
