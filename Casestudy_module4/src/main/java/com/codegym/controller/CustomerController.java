package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
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
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public ModelAndView showListForm(@PageableDefault(value = 5) Pageable pageable){
        Page<Customer> customers = customerService.findAllCustomer(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerType", customerTypeService.findAllCustomerType());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        modelAndView.addObject("customerType", customerTypeService.findAllCustomerType());
        return modelAndView;

    }
    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto,
                               BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            model.addAttribute("message", "Đã tạo thành công khách hàng.");
            customerService.save(customer);
        }
            return "redirect:/customers/list";
        }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer;
        customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
//        Optional<Customer> customerOptional = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customerDto", customerDto);
        modelAndView.addObject("customerType", customerTypeService.findAllCustomerType());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);

        }
        return "redirect:/customers/list";
    }
    @PostMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
       redirectAttributes.addFlashAttribute("message", "Đã xóa thành công!");
       return "redirect:/customers/list";

    }
    @GetMapping("/search")
    public String searchCustomer(@RequestParam(name = "search", required = false) String name,
                                 @PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("customers", customerService.findCustomerByCustomerName(name, pageable));
        return "customer/list";
    }
    @GetMapping("/view/{id}")
    public String detailCustomer(@PathVariable Long id, Model model) {
        Customer customerOptional = customerService.findById(id);
        model.addAttribute("customer" , customerOptional);
        model.addAttribute("customerType", customerTypeService.findAllCustomerType());
        return "customer/view";
    }

}
