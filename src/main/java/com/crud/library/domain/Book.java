package com.crud.library.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "STATUS")
    private BookStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name="TITLE_ID")
    private Title title;

    public Book(BookStatus status, Title title) {
        this.status = status;
        this.title = title;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Title getTitle() {
        return title;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                status == book.status &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, title);
    }
}
