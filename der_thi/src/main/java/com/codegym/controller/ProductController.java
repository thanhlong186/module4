package com.codegym.controller;

import com.codegym.model.Product;
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
//            Product transaction = new Product();
//            BeanUtils.copyProperties(transactionDto, transaction);
//            model.addAttribute("message", "Đã tạo mới thành công");
//            transactionService.save(transaction);
//            return "redirect:/home/list";
//        }
//
//    }
//    @GetMapping("/view/{id}")
//    public String detail(@PathVariable Integer id, Model model) {
//        Product transactions = transactionService.findById(id);
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
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditEmployee(@PathVariable Integer id) {
//        Product transaction;
//        transaction = transactionService.findById(id);
//
//        TransactionDto transactionDto = new TransactionDto();
//        BeanUtils.copyProperties(transaction, transactionDto);
////        Optional<Customer> customerOptional = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("edit");
//        modelAndView.addObject("transactionDto", transactionDto);
//        modelAndView.addObject("customer", customerService.findAllCustomer());
//        modelAndView.addObject("serviceType", serviceTypeService.findAllServiceType());
//        return modelAndView;
//    }
//    @PostMapping("/edit")
//    public String updateEmployee(@Validated @ModelAttribute("transactionDto") TransactionDto transactionDto,
//                                 BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("customer", customerService.findAllCustomer());
//            model.addAttribute("serviceType", serviceTypeService.findAllServiceType());
//            return "edit";
//        } else {
//            Product transaction = new Product();
//            BeanUtils.copyProperties(transactionDto, transaction);
//            transactionService.save(transaction);
//        }
//        return "redirect:/home/list";
//    }
}
