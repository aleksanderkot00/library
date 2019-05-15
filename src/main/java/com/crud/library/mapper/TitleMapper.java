package com.crud.library.mapper;

import com.crud.library.domain.dto.TitleDto;
import com.crud.library.domain.Title;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(titleDto.getTitle(), titleDto.getAuthor(), titleDto.getPublicationYear());
    }

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(title.getTitleName(), title.getAuthor(), title.getPublicationYear());
    }
}
