package com.crud.library.controller;

import com.crud.library.domain.Dto.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @PostMapping(value = "addBook")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(bookService.addBook(bookMapper.mapToBook(bookDto)));
    }

    @GetMapping(value = "numberOfBooks/{titleId}")
    public int numberOfBooks(@PathVariable("titleId") Long titleId) {
        return bookService.numberOfAvailableBooks(titleId);
    }
}
