package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public Title addTitle(Title title) {
        return titleRepository.save(title);
    }
}
