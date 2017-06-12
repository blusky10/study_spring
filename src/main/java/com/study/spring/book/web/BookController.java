package com.study.spring.book.web;

import com.study.spring.book.service.BookService;
import com.study.spring.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long bookId){
        return bookService.getBook(bookId);
    }

    @RequestMapping(value = "/book/all", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

}
