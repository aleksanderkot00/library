package com.crud.library.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "TITLES")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TITLE_ID")
    private Long id;

    @Column(name = "TITLE")
    private String titleName;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATION_YEAR")
    private int publicationYear;

    public Title(String title, String author, int publicationYear) {
        this.titleName = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Title() {
    }

    public Long getId() {
        return id;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return publicationYear == title1.publicationYear &&
                Objects.equals(id, title1.id) &&
                Objects.equals(titleName, title1.titleName) &&
                Objects.equals(author, title1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titleName, author, publicationYear);
    }
}
