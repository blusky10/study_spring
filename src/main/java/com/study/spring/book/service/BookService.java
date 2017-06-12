package com.study.spring.book.service;

import com.study.spring.domain.Book;

import java.util.List;

public interface BookService {
    Book getBook(Long id);

    List<Book> getAllBooks();
}
