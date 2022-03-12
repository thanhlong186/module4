package com.bai_tap.create_app_blog.controller;

import com.bai_tap.create_app_blog.model.Blog;
import com.bai_tap.create_app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
        @Autowired
    private IBlogService blogService;

        @GetMapping("blog")
    public ModelAndView showList() {
            List<Blog> blogList = blogService.findAll();
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("blogs", blogList);
            return modelAndView;
        }
        @GetMapping("/create")
    public ModelAndView showCreateForm(){
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("blog", new Blog());
            return modelAndView;
        }
        @PostMapping("/save")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes) {
            blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
            return "redirect:/blog";
        }
        @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
            Blog blog = blogService.findById(id);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }
        @GetMapping("/delete/{id}")
        public ModelAndView showDeleteForm(@PathVariable int id){
            Blog blog = blogService.findById(id);
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }
        @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
            blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "The blog has been updated successfully.");
            return "redirect:/blog";
        }
    @PostMapping("delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa blog thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }



}
