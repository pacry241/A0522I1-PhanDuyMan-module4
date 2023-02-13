package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/list")
    public String showBook(@RequestParam(value = "page", defaultValue = "0")int page, Model model) {
        model.addAttribute("bookList", iBookService.findIdAndShowBook(PageRequest.of(page,2)));
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrow(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));

        return "/borrow";
    }

    @PostMapping("/saveBorrow")
    public String saveBorrowBook(Book book, RedirectAttributes redirectAttributes) throws Exception {
        iBookService.borrowBook(book);
        if (book.getAmount()==0){
            throw new Exception();
        }
        redirectAttributes.addFlashAttribute("messa1", "Borrowing books successfully !!!");
        return "redirect:/book/list";
    }

    @GetMapping("/pay/{id}")
    public String showPay(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/pay";
    }
    @PostMapping("/savePay")
    public String savePayBook(Book book, RedirectAttributes redirectAttributes) throws Exception {
        iBookService.bookPay(book);
        if (book.getAmount()>book.getCount()){
            throw new Exception();
        }
        redirectAttributes.addFlashAttribute("messa2", "Returned the book !!!");
        return "redirect:/book/list";
    }
}