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
            bookRepository.save(book);
            return rentalRepository.save(rental);
        }
        else throw new WrongBookStatusExcepiton();
    }
}
