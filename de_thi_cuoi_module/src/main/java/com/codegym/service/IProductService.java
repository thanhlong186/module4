package com.codegym.service;

//import com.codegym.model.Transaction;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable);

    Product save(Product product);

    Product findById(Integer id);

    void remove(Integer id);

    Page<Product> findAllByCustomer_NameContaining(String name, Pageable pageable);


}
