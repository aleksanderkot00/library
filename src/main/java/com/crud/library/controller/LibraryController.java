package com.crud.library.controller;

import com.crud.library.domain.BookStatus;
import com.crud.library.domain.Dto.BookDto;
import com.crud.library.domain.Dto.TitleDto;
import com.crud.library.domain.Dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @PostMapping(value = "addUser")
    public UserDto addBook(@RequestBody UserDto userDto) {
        return new UserDto(userDto.getName(),userDto.getLastName(),userDto.getAccountCreationDate());
    }

    @PostMapping(value = "addTitle")
    public TitleDto addTitle(@RequestBody TitleDto titleDto) {
        return new TitleDto(titleDto.getId(), titleDto.getTitle(), titleDto.getAuthor(), titleDto.getPublicationYear());
    }

    @PostMapping(value = "addBook")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return new BookDto(bookDto.getStatus(), bookDto.getTitleId());
    }
}
