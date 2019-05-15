package com.crud.library.domain.dto;

import com.crud.library.domain.BookStatus;

public class BookDto {
    private BookStatus status;
    private Long titleId;

    public BookDto() {
    }

    public BookDto(BookStatus status, Long titleId) {
        this.status = status;
        this.titleId = titleId;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Long getTitleId() {
        return titleId;
    }
}
