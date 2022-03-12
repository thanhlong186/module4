package com.codegym.validate_form_dang_ky.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    private Integer id;
    @NotBlank(message = "Vui long khong duoc de trong!")
    @Size(min=5, max=45, message = "vui long nhap so ki tu nhieu hon 5 va toi da la 45!")
    private String firstName;

    @NotBlank(message = "Vui long khong duoc de trong!")
    @Size(min=5, max=45, message = "vui long nhap so ki tu nhieu hon 5 va toi da la 45!")
    @Size(min=5, max=45)
    private String lastName;

    @NotBlank(message = "vui long khong qua 10 so")
    @Pattern(regexp = "(0[3|7|8|5|9])+([0-9]{8,9})$", message = "vui long nhap bắt đầu bằng 0, và phai 10 hoặc 11 so")
    private String phoneNumber;

    @Min(value = 18, message = "vui long nhap so tuoi lon hon 18")
    private Integer age;

    @NotNull(message =  "vui long khong de trong")
    @NotBlank(message = "vui long khong nhap khoang trang")
    @Email(message = "vui long nhap dung chuan!")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
