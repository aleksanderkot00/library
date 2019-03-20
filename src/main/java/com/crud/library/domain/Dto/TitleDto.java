package com.crud.library.domain.Dto;

public class TitleDto {
    private Long id;
    private String title;
    private String author;
    private int publicationYear;

    public TitleDto() {
    }

    public TitleDto(Long id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Long getId() {
        return id;
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
