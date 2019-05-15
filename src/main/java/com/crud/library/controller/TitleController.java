package com.crud.library.controller;

import com.crud.library.domain.dto.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @Autowired
    private TitleMapper titleMapper;

    @PostMapping(value = "addTitle")
    public TitleDto addTitle(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(titleService.addTitle(titleMapper.mapToTitle(titleDto)));
    }
}
