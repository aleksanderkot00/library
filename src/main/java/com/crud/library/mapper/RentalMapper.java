package com.crud.library.mapper;

import com.crud.library.domain.dto.RentalDto;
import com.crud.library.domain.Rental;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.exception.UserNotFoundException;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Rental mapToRental(RentalDto rentalDto) {
        return new Rental(bookRepository.findById(rentalDto.getBookId()).orElseThrow(BookNotFoundException::new),
                userRepository.findById(rentalDto.getUserId()).orElseThrow(UserNotFoundException::new),
                rentalDto.getRentalDate(), rentalDto.getReturnDate());
    }

    public RentalDto mapToRentalDto(Rental rental) {
        return new RentalDto(rental.getBook().getId(), rental.getUser().getId(), rental.getRentalDate(), rental.getReturnDate());
    }
}
