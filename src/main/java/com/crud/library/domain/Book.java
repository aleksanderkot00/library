package com.crud.library.domain;

import javax.persistence.*;

@Entity(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "STATUS")
    private int status;

    @ManyToOne(optional = false)
    @JoinColumn(name="TITLE_ID")
    private Title title;

    public Book(int status, Title title) {
        this.status = status;
        this.title = title;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public Title getTitle() {
        return title;
    }
}
