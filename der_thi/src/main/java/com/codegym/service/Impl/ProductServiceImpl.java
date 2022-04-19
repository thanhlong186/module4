package com.codegym.service.Impl;

import com.codegym.model.Product;
import com.codegym.repository.ITransactionRepository;
import com.codegym.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public Page<Product> findAllTransaction(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Product save(Product transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Product findById(Integer id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public void remove(Integer id) {
        transactionRepository.deleteById(id);

    }

    @Override

    public Page<Product> findAllByCustomer_NameContaining(String name, Pageable pageable) {
        return transactionRepository.findAllByCustomer_NameContaining(name, pageable);
    }
//
//    @Override
//    public Page<Transaction> findByServiceTypeAndId(Integer id,Pageable pageable) {
//        return transactionRepository.findByServiceTypeAndId(id,pageable);
//    }

//    @Override
//    public Page<Transaction> findAllByServiceType_NameContaining(String name, Pageable pageable) {
//        return transactionRepository.findAllByServiceType_NameContaining(name, pageable);
//    }

}
