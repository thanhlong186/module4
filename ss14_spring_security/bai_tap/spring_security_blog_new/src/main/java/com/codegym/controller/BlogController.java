package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class BlogController {
        @Autowired
    private IBlogService blogService;

        @Autowired
        private ICategoryService categoryService;

        @GetMapping(value = "/blog")
    public ModelAndView showList(@PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
            Page<Blog> blogList = blogService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("blogs", blogList);
            return modelAndView;
        }
        @GetMapping("/create")
    public ModelAndView showCreateForm(){
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("blog", new Blog());
            modelAndView.addObject("category", categoryService.findAll());
            return modelAndView;
        }
        @PostMapping("/save")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes) {
            blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
            return "redirect:/blog";
        }
        @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
            Blog blog = blogService.findById(id);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }
        @GetMapping("/delete/{id}")
        public ModelAndView showDeleteForm(@PathVariable Long id){
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
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }



}
