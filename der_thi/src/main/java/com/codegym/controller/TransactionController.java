package com.codegym.controller;

import com.codegym.dto.TransactionDto;
import com.codegym.model.Transaction;
import com.codegym.service.ICustomerService;
import com.codegym.service.IServiceTypeService;
import com.codegym.service.ITransactionService;
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

import java.util.List;

@Controller
@RequestMapping("/home")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Transaction> transactions = transactionService.findAllTransaction(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("transactions", transactions);
        modelAndView.addObject("customer", customerService.findAllCustomer());
        modelAndView.addObject("serviceType", serviceTypeService.findAllServiceType());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("transactionDto", new TransactionDto());
        modelAndView.addObject("customer", customerService.findAllCustomer());
        modelAndView.addObject("serviceType", serviceTypeService.findAllServiceType());
        return modelAndView;
    }
    @PostMapping("/save")
    public String createTransaction(@Validated @ModelAttribute TransactionDto transactionDto,
                                    BindingResult bindingResult, Model model) {
        new TransactionDto().validate(transactionDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customer" , customerService.findAllCustomer());
            model.addAttribute("serviceType", serviceTypeService.findAllServiceType());
            return "create";
        } else {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(transactionDto, transaction);
            model.addAttribute("message", "Đã tạo mới thành công");
            transactionService.save(transaction);
            return "redirect:/home/list";
        }

    }
    @GetMapping("/view/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Transaction transactions = transactionService.findById(id);
        model.addAttribute("transaction", transactions);
        return "view";
    }
    @GetMapping("/delete")
    public String deleteTransaction(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        transactionService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa thành công");
        return "redirect:/home/list";
    }
    @GetMapping("/search")
    public String searchTransaction(@RequestParam(name = "search", required = false) String name,
                                    @PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("transactions", transactionService.findAllByCustomer_NameContaining(name, pageable));
//        model.addAttribute("transactions", transactionService.findAllByServiceType_NameContaining(name, pageable));
        return "list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditEmployee(@PathVariable Integer id) {
        Transaction transaction;
        transaction = transactionService.findById(id);

        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
//        Optional<Customer> customerOptional = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("transactionDto", transactionDto);
        modelAndView.addObject("customer", customerService.findAllCustomer());
        modelAndView.addObject("serviceType", serviceTypeService.findAllServiceType());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String updateEmployee(@Validated @ModelAttribute("transactionDto") TransactionDto transactionDto,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customerService.findAllCustomer());
            model.addAttribute("serviceType", serviceTypeService.findAllServiceType());
            return "edit";
        } else {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(transactionDto, transaction);
            transactionService.save(transaction);
        }
        return "redirect:/home/list";
    }
}
