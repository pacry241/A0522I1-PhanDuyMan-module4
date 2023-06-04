package com.example.borrowbook.repository;

import com.example.borrowbook.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book, Integer> {
    Book findById(int id);

    Page<Book> findByName(String name, Pageable pageable);
}
