package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.Dto.BookDto;
import com.crud.library.exception.TitleNotFoundException;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    @Autowired
    private TitleRepository titleRepository;

    public Book mapToBook(BookDto bookDto) {
        return new Book(bookDto.getStatus(), titleRepository.findById(bookDto.getTitleId()).orElseThrow(TitleNotFoundException::new));
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(book.getStatus(), book.getTitle().getId());
    }
}
