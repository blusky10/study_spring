package com.study.spring.book.service;

import com.study.spring.domain.Book;

import java.util.List;

/**
 * Created by SDS on 2017-06-12.
 */
public interface BookService {
    Book getBook(Long id);

    List<Book> getAllBooks();
}
