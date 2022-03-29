package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationDegreeService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;

    @GetMapping
    public String showListEmployee() {
        return "home";
    }
    @GetMapping("/list")
    public ModelAndView showListEmployee(@PageableDefault(value = 5) Pageable pageable){
        Page<Employee> employees = employeeService.findAllEmployee(pageable);
        ModelAndView modelAndView= new ModelAndView("employee/list");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("position", positionService.findAllPosition());
        modelAndView.addObject("educationDegree", educationDegreeService.findAllEducation());
        modelAndView.addObject("division", divisionService.findAllDivision());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateEmployee(){
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        modelAndView.addObject("position", positionService.findAllPosition());
        modelAndView.addObject("educationDegree", educationDegreeService.findAllEducation());
        modelAndView.addObject("division", divisionService.findAllDivision());
        return modelAndView;
    }
    @PostMapping("/save")
        public String saveEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                   BindingResult bindingResult, Model model){
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", positionService.findAllPosition());
            model.addAttribute("educationDegree", educationDegreeService.findAllEducation());
            model.addAttribute("division", divisionService.findAllDivision());
            return "employee/create";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            model.addAttribute("message", "Đã tạo mới nhân viên thành công.");
            employeeService.save(employee);
            return "redirect:/employees/list";
        }
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditEmployee(@PathVariable Integer id) {
        Employee employee;
        employee = employeeService.findById(id);

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
//        Optional<Customer> customerOptional = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employeeDto", employeeDto);
        modelAndView.addObject("position", positionService.findAllPosition());
        modelAndView.addObject("educationDegree", educationDegreeService.findAllEducation());
        modelAndView.addObject("division", divisionService.findAllDivision());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String updateEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", positionService.findAllPosition());
            model.addAttribute("educationDegree", educationDegreeService.findAllEducation());
            model.addAttribute("division", divisionService.findAllDivision());
            return "/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
        }
        return "redirect:/employees/list";
    }
    @GetMapping("/search")
    public String deleteEmployee(@RequestParam(name = "searchEmployee", required = false) String name,
                                 @PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("employees", employeeService.findByNameEmployee(name, pageable));
        return "employee/list";
    }
    @GetMapping("/delete")
    public String searchEmployee(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa thành công!");
        return "redirect:/employees/list";
    }
    @GetMapping("/view/{id}")
    public String detailEmployee(@PathVariable Integer id, Model model){
        Employee employeeOptional = employeeService.findById(id);
        model.addAttribute("employee", employeeOptional);
        model.addAttribute("position", positionService.findAllPosition());
        model.addAttribute("educationDegree", educationDegreeService.findAllEducation());
        model.addAttribute("division", divisionService.findAllDivision());
        return "employee/view";
    }


}
