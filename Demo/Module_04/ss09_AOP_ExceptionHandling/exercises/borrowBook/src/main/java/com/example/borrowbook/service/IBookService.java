package com.example.borrowbook.service;

import com.example.borrowbook.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Book findById(int id);
    Page<Book> findIdAndShowBook(Pageable pageable);
    Book borrowBook(Book book) throws Exception;
    Book bookPay(Book book);
}
