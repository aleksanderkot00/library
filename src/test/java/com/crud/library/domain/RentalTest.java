package com.crud.library.domain;

import com.crud.library.repository.BookRepository;
import com.crud.library.repository.RentalRepository;
import com.crud.library.repository.TitleRepository;
import com.crud.library.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalTest {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        //Given
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        titleRepository.save(title);

        Book book = new Book(BookStatus.AVAILABLE, title);
        bookRepository.save(book);

        Date date = Date.valueOf(LocalDate.now());
        User user = new User( "Aleksander", "Kot", date);
        userRepository.save(user);

        Date returnDate = Date.valueOf(LocalDate.of(2019,3,3));
        Date rentalDate = Date.valueOf(LocalDate.of(2018,12,3));
        Rental rental = new Rental(book, user, rentalDate, returnDate);

        int initialNumberOfRentals = rentalRepository.findAll().size();

        //When
        rentalRepository.save(rental);
        int numberOfRentals = rentalRepository.findAll().size();

        //Then
        Assert.assertEquals(initialNumberOfRentals + 1, numberOfRentals);

        //Clean-up
        rentalRepository.delete(rental.getId());
        bookRepository.delete(book.getId());
        titleRepository.delete(title.getId());
        userRepository.delete(user.getId());
    }
}