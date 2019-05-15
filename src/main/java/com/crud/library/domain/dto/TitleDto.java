package com.crud.library.domain.dto;

public class TitleDto {
    private String title;
    private String author;
    private int publicationYear;

    public TitleDto() {
    }

    public TitleDto(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
