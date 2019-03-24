package com.crud.library.controller;

import com.crud.library.domain.Dto.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class TitleController {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private TitleMapper titleMapper;

    @PostMapping(value = "addTitle")
    public TitleDto addTitle(@RequestBody TitleDto titleDto) {
//        return new TitleDto(titleDto.getTitle(),titleDto.getAuthor(),titleDto.getPublicationYear());
//        return new TitleDto("Harry Potter", "J.K. Rowling", 2004);
        return titleMapper.mapToTitleDto(titleRepository.save(titleMapper.mapToTitle(titleDto)));
    }
}
