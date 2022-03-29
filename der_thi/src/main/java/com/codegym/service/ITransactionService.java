package com.codegym.service;

import com.codegym.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransactionService {
    Page<Transaction> findAllTransaction(Pageable pageable);

    Transaction save(Transaction transaction);

    Transaction findById(Integer id);

    void remove(Integer id);

    Page<Transaction> findAllByCustomer_NameContaining(String name, Pageable pageable);

//    Page<Transaction> findAllByServiceType_NameContaining(String name, Pageable pageable);
//Page<Transaction> findByServiceTypeAndId(Integer id,Pageable pageable);

}
