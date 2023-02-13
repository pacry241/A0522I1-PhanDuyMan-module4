package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
   @Query(value = "select * from books", nativeQuery = true)
    Page<Book> findAllWithPage(PageRequest pageRequest);
}
