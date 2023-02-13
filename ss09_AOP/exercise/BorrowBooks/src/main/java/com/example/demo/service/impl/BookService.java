package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository repository;
    @Override
    public Book findById(int id) {
        return repository.findById(id).orElse(new Book());
    }

    @Override
    public Page<Book> findIdAndShowBook(PageRequest pageRequest) {
        return repository.findAllWithPage(pageRequest);
    }

    @Override
    public Book borrowBook(Book book) throws Exception {
        book.setAmount(book.getAmount()-1);
        return repository.save(book);
    }

    @Override
    public Book bookPay(Book book) {
        book.setAmount(book.getAmount()+1);
        return repository.save(book);
    }
}
