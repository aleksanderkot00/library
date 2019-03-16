package com.crud.library.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "RENTALS")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RENTAL_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name="BOOK_ID")
    private Book book;

    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @Column(name = "RENTAL_DATE")
    private Date rentalDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public Rental() {
    }

    public Rental(Book book, User user, Date rentalDate, Date returnDate) {
        this.book = book;
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}