package com.codegym.dto;

import com.codegym.model.RentType;
import com.codegym.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ServiceDto implements Validator {

    private Integer id;

    @Pattern(regexp = "^(DV)(-)[0-9]{4}$", message = "Vui lòng nhập đúng định dạng DV-XXXX. Ví dụ: DV-1234")
    @NotBlank(message = "Vui lòng không để trống.")
    private String codeService;

    @NotBlank(message = "Vui lòng không để trống.")
    @Size(min=5, max=45, message = "vui lòng nhập số kí tự nhiều hơn 5 và nhở hơn 45")
    private String serviceName;

    private Integer area;

    private Double serviceCost;

    private Integer serviceMaxPeople;

    @NotBlank(message = "Vui lòng không để trống.")
    private String description;

    private Double poolArea;

    private Integer numberOfFloors;

    private ServiceType serviceType;

    private RentType rentType;

    public ServiceDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if(serviceDto.numberOfFloors == null || serviceDto.numberOfFloors < 0) {
            errors.rejectValue("numberOfFloors", "", "số tầng phải là số dương nha.");
        }
        if(serviceDto.serviceMaxPeople == null || serviceDto.serviceMaxPeople < 0) {
            errors.rejectValue("serviceMaxPeople", "", "Số lượng phải dương nha.");
        }
        if(serviceDto.poolArea == null ||serviceDto.poolArea < 0) {
            errors.rejectValue("poolArea", "", "Không được để số âm nha.");
        }
    }
}
