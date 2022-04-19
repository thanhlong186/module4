package com.codegym.controller;

//import com.codegym.dto.TransactionDto;
//import com.codegym.model.Transaction;
//import com.codegym.service.ICustomerService;
//import com.codegym.service.IServiceTypeService;
import com.codegym.model.Product;
import com.codegym.repository.IProductTypeRepository;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
        @Autowired
        private IProductTypeService productTypeService;

    @GetMapping
    public String home(){
        return "home";
    }

//    @GetMapping("/list")
//    public String listTrans() {
//        return "list";
//    }
//    @GetMapping("/view")
//    public String editTrans() {
//        return "view";
//    }

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Product> products = productService.findAllProduct(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", products);
        modelAndView.addObject("productType", productTypeService.findAllProductType());
        return modelAndView;
    }
//    @GetMapping("/create")
//    public ModelAndView showCreate(){
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("transactionDto", new TransactionDto());
//        modelAndView.addObject("customer", customerService.findAllCustomer());
//        modelAndView.addObject("serviceType", serviceTypeService.findAllServiceType());
//        return modelAndView;
//    }
//    @PostMapping("/save")
//    public String createTransaction(@Validated @ModelAttribute TransactionDto transactionDto,
//                                    BindingResult bindingResult, Model model) {
//        new TransactionDto().validate(transactionDto, bindingResult);
//        if (bindingResult.hasErrors()){
//            model.addAttribute("customer" , customerService.findAllCustomer());
//            model.addAttribute("serviceType", serviceTypeService.findAllServiceType());
//            return "create";
//        } else {
//            Transaction transaction = new Transaction();
//            BeanUtils.copyProperties(transactionDto, transaction);
//            model.addAttribute("message", "Đã tạo mới thành công");
//            transactionService.save(transaction);
//            return "redirect:/home/list";
//        }
//
//    }
//    @GetMapping("/view/{id}")
//    public String detail(@PathVariable Integer id, Model model) {
//        Transaction transactions = transactionService.findById(id);
//        model.addAttribute("transaction", transactions);
//        return "view";
//    }
//    @GetMapping("/delete")
//    public String deleteTransaction(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
//        transactionService.remove(id);
//        redirectAttributes.addFlashAttribute("message", "Đã xóa thành công");
//        return "redirect:/home/list";
//    }
//    @GetMapping("/search")
//    public String searchTransaction(@RequestParam(name = "search", required = false) String name,
//                                    @PageableDefault(value = 3) Pageable pageable, Model model) {
//        model.addAttribute("transactions", transactionService.findAllByCustomer_NameContaining(name, pageable));
////        model.addAttribute("transactions", transactionService.findAllByServiceType_NameContaining(name, pageable));
//        return "list";
//    }
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditEmployee(@PathVariable Integer id) {
//        Employee employee;
//        employee = employeeService.findById(id);
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        BeanUtils.copyProperties(employee, employeeDto);
////        Optional<Customer> customerOptional = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/employee/edit");
//        modelAndView.addObject("employeeDto", employeeDto);
//        modelAndView.addObject("position", positionService.findAllPosition());
//        modelAndView.addObject("educationDegree", educationDegreeService.findAllEducation());
//        modelAndView.addObject("division", divisionService.findAllDivision());
//        return modelAndView;
//    }
//    @PostMapping("/edit")
//    public String updateEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto,
//                                 BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("position", positionService.findAllPosition());
//            model.addAttribute("educationDegree", educationDegreeService.findAllEducation());
//            model.addAttribute("division", divisionService.findAllDivision());
//            return "/employee/edit";
//        } else {
//            Employee employee = new Employee();
//            BeanUtils.copyProperties(employeeDto, employee);
//            employeeService.save(employee);
//        }
//        return "redirect:/employees/list";
//    }

}
