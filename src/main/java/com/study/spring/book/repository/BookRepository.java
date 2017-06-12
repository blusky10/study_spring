package com.study.spring.book.repository;

import com.study.spring.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SDS on 2017-06-12.
 */
public interface BookRepository extends JpaRepository<Book, Long>{
}
