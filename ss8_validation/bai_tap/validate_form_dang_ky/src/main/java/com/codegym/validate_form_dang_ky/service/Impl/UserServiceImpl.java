package com.codegym.validate_form_dang_ky.service.Impl;

import com.codegym.validate_form_dang_ky.model.User;
import com.codegym.validate_form_dang_ky.repository.IUserRepository;
import com.codegym.validate_form_dang_ky.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {

        userRepository.save(user);
    }
}


