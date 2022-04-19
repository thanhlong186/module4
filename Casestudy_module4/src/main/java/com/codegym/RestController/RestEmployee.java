package com.codegym.RestController;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Employee;
import com.codegym.model.Position;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationDegreeService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RestEmployee {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @GetMapping("/employee/api/v1")
    public ResponseEntity<List<Employee>> getEmployeeList() {
        List<Employee> employeeList = employeeService.findAll();
            if (employeeList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @GetMapping("/position/api/v1")
    public ResponseEntity<List<Position>> getPositionList() {
        List<Position> positionList = positionService.findAllPosition();
        if (positionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }
    @GetMapping("/education/api/v1")
    public ResponseEntity<List<EducationDegree>> getEducationList() {
        List<EducationDegree> educationDegreeList = educationDegreeService.findAllEducation();
        if (educationDegreeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(educationDegreeList, HttpStatus.OK);
    }
    @GetMapping("/division/api/v1")
    public ResponseEntity<List<Division>> getDivisionList() {
        List<Division> divisionList = divisionService.findAllDivision();
        if (divisionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(divisionList, HttpStatus.OK);
    }
}
