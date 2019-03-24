package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookStatus;
import com.crud.library.exception.TitleNotFoundException;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TitleRepository titleRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public int numberOfAvailableBooks(Long titleId){
        return bookRepository.findAllByStatusAndTitle(BookStatus.AVAILABLE,
                titleRepository.findById(titleId).orElseThrow(TitleNotFoundException::new)).size();
    }
}
