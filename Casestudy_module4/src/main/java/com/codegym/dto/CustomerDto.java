package com.codegym.dto;

import com.codegym.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDto implements Validator {


    private Long id;

    @Pattern(regexp = "^(KH)(-)[0-9]{4}$",message = "Hay Nhập Đúng Định Dạng KH-(XXXX). ví dụ: KH-1234")
    @NotBlank(message = "Vui lòng không được để trống!")
    private String codeName;

    @NotBlank(message = "Vui lòng không được để trống!")
    @Size(min=5, max=45, message = "vui lòng nhập số kí tự nhiều hơn 5 và nhở hơn 45")
    private String customerName;

    private String customerBirthday;

    @NotBlank(message = "Vui lòng không được để trống!")
    private String gender;

    @NotBlank(message = "Vui lòng không được để trống!")
    @Pattern(regexp = "^[0-9]{9}", message = "vui lòng nhập đúng định dạng và đủ 9 số. vd: 123456789")
    private String customerIdCard;

    @NotBlank(message = "Vui lòng không được để trống!")
    @Pattern(regexp = "(0[3|7|8|5|9])+([0-9]{8,9})$", message = "vui lòng nhập 10 số hay 11 số bắt đầu bằng 0")
    private String phone;

    @NotBlank(message = "Vui lòng không được để trống!")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Vui lòng nhập đúng định dạng")
    private String email;

    @NotBlank(message = "Vui lòng không được để trống!")
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
