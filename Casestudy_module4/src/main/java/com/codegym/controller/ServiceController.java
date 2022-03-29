package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.Service;
import com.codegym.service.IRentTypeService;
import com.codegym.service.IService;
import com.codegym.service.IServiceType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private IService iService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceType serviceType;

    @GetMapping
    public String showHomeService(){
        return "home";
    }
    @GetMapping("/list")
    public ModelAndView showListService() {
        List<Service> serviceList = iService.findAllService();
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("services", serviceList);
        modelAndView.addObject("serviceType", serviceType.findAllServiceType());
        modelAndView.addObject("rentType", rentTypeService.findAllRentType());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateService() {
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("serviceDto", new ServiceDto());
        modelAndView.addObject("serviceType", serviceType.findAllServiceType());
        modelAndView.addObject("rentType", rentTypeService.findAllRentType());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createService(@Validated @ModelAttribute("serviceDto") ServiceDto serviceDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        new ServiceDto().validate(serviceDto, bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("serviceType", serviceType.findAllServiceType());
            model.addAttribute("rentType", rentTypeService.findAllRentType());
            return "service/create";
        } else{
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            redirectAttributes.addFlashAttribute("message", "Đã tạo mới thànhc công dịch vụ.");
            iService.save(service);
        }
        return "redirect:/services/list";
    }
}
