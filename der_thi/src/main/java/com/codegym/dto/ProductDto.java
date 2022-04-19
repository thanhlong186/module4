package com.codegym.dto;

import com.codegym.model.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ProductDto implements Validator {

    private Integer id;


    private String select;

    @NotBlank
    private String name;


    private String price;
    @NotBlank
    private Double status;



    private ProductType customer;


    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public ProductType getCustomer() {
        return customer;
    }

    public void setCustomer(ProductType customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto transactionDto = (ProductDto) target;
//        if(transactionDto.price == null || transactionDto.price < 500000.0) {
//            errors.rejectValue("price","", "Số tiền phái lớn hơn 500.000 đồng");
//        }

        }
    }

