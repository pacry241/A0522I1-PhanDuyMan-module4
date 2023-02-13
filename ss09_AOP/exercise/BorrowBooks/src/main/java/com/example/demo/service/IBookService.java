package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IBookService {
    Book findById(int id);
    Page<Book> findIdAndShowBook(PageRequest pageRequest);
    Book borrowBook(Book book) throws Exception;
    Book bookPay(Book book);
}
