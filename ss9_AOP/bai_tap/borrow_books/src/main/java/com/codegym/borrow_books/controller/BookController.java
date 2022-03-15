package com.codegym.borrow_books.controller;

import com.codegym.borrow_books.model.Books;
import com.codegym.borrow_books.model.CodeBook;
import com.codegym.borrow_books.service.IBookService;
import com.codegym.borrow_books.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICodeBookService codeBookService;

    @GetMapping("/book")
    public ModelAndView showList(){
        List<Books> booksList = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("booksList", booksList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("book", new Books());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveCreate(Books books, RedirectAttributes redirectAttributes){
            bookService.save(books);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
            return "redirect:/book";
    }
    @GetMapping("/borrow/{id}")
    public String showBorrow(@PathVariable int id, Model model) {
        Books book = bookService.findById(id);
        if (book.getAmount() == 0) {
            return "errror.404";
        }
        int amount = book.getAmount();
        book.setAmount(amount - 1);
        bookService.save(book);
        int codeNew = (int) Math.floor(((Math.random()*89999) + 10000));
        String codeRandom = String.valueOf(codeNew);
        model.addAttribute("code", codeRandom);
        CodeBook codeBook = new CodeBook();
        codeBook.setCode(codeRandom);
        codeBook.setBooks(book);
        codeBookService.save(codeBook);
        return "borrow";
    }
    @GetMapping("/give-back/{id}")
    public ModelAndView showGiveBack() {
        return  new ModelAndView("giveBack", "codeBook", new CodeBook());
    }
    @PostMapping("/give-back")
    public String giveBackBook(@RequestParam String codeBook, RedirectAttributes redirectAttributes) {
        CodeBook codeBookNew = codeBookService.findByCode(codeBook);
        Books books = bookService.findById(codeBookNew.getBooks().getId());
        books.setAmount(books.getAmount() + 1);
        bookService.save(books);
        codeBookService.remove(codeBookNew.getId());
        redirectAttributes.addFlashAttribute("message", "hello");
        return "redirect:/book";
    }
}
