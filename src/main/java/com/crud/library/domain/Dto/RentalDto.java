package com.crud.library.domain.Dto;

import java.sql.Date;

public class RentalDto {
    private Long bookId;
    private Long userId;
    private Date rentalDate;
    private Date returnDate;

    public RentalDto() {
    }

    public RentalDto(Long bookId, Long userId, Date rentalDate, Date returnDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
