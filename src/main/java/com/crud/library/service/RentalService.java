package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookStatus;
import com.crud.library.domain.Rental;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.exception.WrongBookStatusExcepiton;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private BookRepository bookRepository;

    public Rental addRental(Rental rental) {
        Book book = bookRepository.findById(rental.getBook().getId()).orElseThrow(BookNotFoundException::new);

        if (book.getStatus() == BookStatus.AVAILABLE) {
            book.setStatus(BookStatus.RENTED);
        } else throw new WrongBookStatusExcepiton();

        bookRepository.save(book);
        return rentalRepository.save(rental);
    }

    public Rental returnBook(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId).get();
        Book book = rental.getBook();
        if (book.getStatus() == BookStatus.RENTED) {
            book.setStatus(BookStatus.AVAILABLE);
        } else throw new WrongBookStatusExcepiton();

        bookRepository.save(book);
        rental.setReturnDate(Date.valueOf(LocalDate.now()));
        return rentalRepository.save(rental);
    }
}
