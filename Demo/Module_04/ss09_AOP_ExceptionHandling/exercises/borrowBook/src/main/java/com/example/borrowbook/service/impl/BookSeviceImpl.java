package com.example.borrowbook.service.impl;

import com.example.borrowbook.model.Book;
import com.example.borrowbook.repository.IBookRepository;
import com.example.borrowbook.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookSeviceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }

    @Override
    public Page<Book> findIdAndShowBook(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Book borrowBook(Book book) throws Exception {
        book.setAmount(book.getAmount()-1);
        return iBookRepository.save(book);
    }

    @Override
    public Book bookPay(Book book) {
        book.setAmount(book.getAmount()+1);
        return iBookRepository.save(book);
    }
}
