package com.codegym.dto;

import com.codegym.model.Customer;
import com.codegym.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class TransactionDto implements Validator {

    private Integer id;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^(MGD)(-)[0-9]{4}$", message = "Vui lòng nhập đúng định dạng (MGD-XXXX) Ví dụ: MGD-1234")
    private String codeTransaction;


    @NotBlank(message = "Vui lòng không để trống")
    private String date;

    @Min(value = 500000, message = "Số tiền phải lớn hơn 500.000 đồng")
    @Positive
    @NotNull
    private Double price;

    private Double area;

    private Customer customer;

    private ServiceType serviceType;

    public TransactionDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeTransaction() {
        return codeTransaction;
    }

    public void setCodeTransaction(String codeTransaction) {
        this.codeTransaction = codeTransaction;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TransactionDto transactionDto = (TransactionDto) target;
//        if(transactionDto.price == null || transactionDto.price < 500000.0) {
//            errors.rejectValue("price","", "Số tiền phái lớn hơn 500.000 đồng");
//        }
        if (transactionDto.area == null || transactionDto.area < 20.0) {
            errors.rejectValue("area", "", "Diện tích phải lớn hơn 20m2");
        }
    }
}
