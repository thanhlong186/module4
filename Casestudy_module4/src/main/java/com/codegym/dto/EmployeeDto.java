package com.codegym.dto;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class EmployeeDto implements Validator {

    private Integer id;

    @Pattern(regexp = "^(NV)(-)[0-9]{5}$",message = "Hay Nhập Đúng Định Dạng NV-(XXXXX). ví dụ: NV-12345")
    private String codeEmployee;

    @Size(min=5, max=45, message = "vui lòng nhập số kí tự nhiều hơn 5 và nhở hơn 45")
    @NotBlank(message = "Vui lòng không để trống")
    private String employeeName;

    @NotBlank(message = "Vui lòng không để trống")
    private String employeeBirthday;

    @Pattern(regexp = "^[0-9]{9}", message = "vui lòng nhập đúng định dạng và đủ 9 số. vd: 123456789")
    @NotBlank(message = "Vui lòng không để trống")
    private String employeeIdCard;


    private Double salary;

    @Pattern(regexp = "(0[3|7|8|5|9])+([0-9]{8,9})$", message = "vui lòng nhập 10 số hay 11 số bắt đầu bằng 0")
    @NotBlank(message = "Vui lòng không để trống")
    private String employeePhone;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Vui lòng nhập đúng định dạng(...@...com")
    @NotBlank(message = "Vui lòng không để trống")
    private String email;

    @NotBlank(message = "Vui lòng không để trống")
    private String address;

    private Position position;

    private EducationDegree education;

    private Division division;

    public EmployeeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducation() {
        return education;
    }

    public void setEducation(EducationDegree education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.salary == null || employeeDto.salary < 0){
                errors.rejectValue("salary","", "Vui lòng không nhập số âm");
        }
    }
}
