package com.example.springbootmultidb.repository.book;

import com.example.springbootmultidb.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
