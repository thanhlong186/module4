package com.thuc_hanh.service.impl;

import com.thuc_hanh.model.Customer;
import com.thuc_hanh.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerServiceImpl implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Tuan", "Tuan@codegym.vn", "Da Nng"));
        customers.put(2, new Customer(2, "Trong", "Trong@codegym.vn", "Da Nang"));
        customers.put(3, new Customer(3, "Ngoc", "Ngoc@codegym.vn", "Hue"));
        customers.put(4, new Customer(4, "Long", "Long@codegym.vn", "London"));
        customers.put(5, new Customer(5, "Linh", "Linh@codegym.vn", "Angola"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
            customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
