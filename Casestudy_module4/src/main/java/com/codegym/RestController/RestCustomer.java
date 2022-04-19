package com.codegym.RestController;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class RestCustomer {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("/customer/api")
    public ResponseEntity<List<Customer>> getCustomerList(){
        List<Customer> customerList = customerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/customerType/api")
    public ResponseEntity<List<CustomerType>> getCustomerTypeList(){
        List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
        if (customerTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
    }
    @PostMapping("/customer-create")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("customer-edit/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
       Customer customerOptional = customerService.findById(id);
       if (customerOptional==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }
    @DeleteMapping("customer-delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
//        List<Customer> customers = customerService.remove(id);
        if(customerService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}
