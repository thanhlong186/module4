package com.codegym.RestController;

import com.codegym.model.RentType;
import com.codegym.model.Service;
import com.codegym.model.ServiceType;
import com.codegym.service.IRentTypeService;
import com.codegym.service.IService;
import com.codegym.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RestFacility {

    @Autowired
    private IService service;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceType serviceType;

    @GetMapping("/rentType/api/v1")
    public ResponseEntity<List<RentType>> getRentTypeList() {
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        if(rentTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rentTypeList, HttpStatus.OK);
    }
    @GetMapping("/serviceType/api/v1")
    public ResponseEntity<List<ServiceType>> getServiceTypeList() {
        List<ServiceType> serviceTypeList = serviceType.findAllServiceType();
        if(serviceTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceTypeList, HttpStatus.OK);
    }
    @GetMapping("/facility/api/v1")
    public ResponseEntity<List<Service>> getServiceList() {
        List<Service> serviceList = service.findAllService();
        if(serviceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }
}
