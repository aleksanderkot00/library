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
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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

    @Transactional
    @Test
    public void testSaveAndFindAll() {
        //Given
        int initialNumberOfRentals = rentalRepository.findAll().size();

        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Book book = new Book(BookStatus.AVAILABLE, title);
        User user = new User( "Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        titleRepository.save(title);
        bookRepository.save(book);
        userRepository.save(user);

        Rental rental1 = new Rental(
                book,
                user,
                Date.valueOf(LocalDate.of(2018,12,3)),
                Date.valueOf(LocalDate.of(2019,3,3))
        );

        Rental rental2 = new Rental(
                book,
                user,
                Date.valueOf(LocalDate.of(2019,3,3)),
                Date.valueOf(LocalDate.of(2020,12,3))
        );

        //When
        rentalRepository.save(rental1);
        rentalRepository.save(rental2);

        List<Rental> rentals = rentalRepository.findAll();
        int numberOfRentals = rentals.size();

        //Then
        Assert.assertEquals(initialNumberOfRentals + 2, numberOfRentals);
        Assert.assertTrue(rentals.contains(rental1));
        Assert.assertTrue(rentals.contains(rental2));

        //CleanUp
//        rentalRepository.delete(rental1.getId());
//        rentalRepository.delete(rental2.getId());
//        bookRepository.delete(book.getId());
//        titleRepository.delete(title.getId());
//        userRepository.delete(user.getId());
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Book book = new Book(BookStatus.AVAILABLE, title);
        User user = new User( "Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        titleRepository.save(title);
        bookRepository.save(book);
        userRepository.save(user);

        Rental rental = new Rental(
                book,
                user,
                Date.valueOf(LocalDate.of(2018,12,3)),
                Date.valueOf(LocalDate.of(2019,3,3))
        );
        rentalRepository.save(rental);

        //When
        Rental foundRental = rentalRepository.findById(rental.getId()).get();

        //Then
        Assert.assertEquals(rental, foundRental);

        //CleanUp
//        rentalRepository.delete(rental.getId());
//        userRepository.delete(user.getId());
//        bookRepository.delete(book.getId());
//        titleRepository.delete(title.getId());
    }

    @Transactional
    @Test
    public void testDelete() {
        //Given
        int initialNumberOfRentals = rentalRepository.findAll().size();

        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Book book = new Book(BookStatus.AVAILABLE, title);
        User user = new User("Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        titleRepository.save(title);
        bookRepository.save(book);
        userRepository.save(user);

        Rental rental = new Rental(
                book,
                user,
                Date.valueOf(LocalDate.of(2018, 12, 3)),
                Date.valueOf(LocalDate.of(2019, 3, 3))
        );
        rentalRepository.save(rental);

        //When
        rentalRepository.delete(rental);
        List<Rental> rentals = rentalRepository.findAll();
        int numberOfRentals = rentals.size();

        //Then
        Assert.assertEquals(initialNumberOfRentals, numberOfRentals);
        Assert.assertFalse(rentals.contains(rental));

        //CleanUp
//        userRepository.delete(user.getId());
//        bookRepository.delete(book.getId());
//        titleRepository.delete(title.getId());
    }

    @Transactional
    @Test
    public void testDeleteById() {
        //Given
        int initialNumberOfRentals = rentalRepository.findAll().size();

        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Book book = new Book(BookStatus.AVAILABLE, title);
        User user = new User("Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        titleRepository.save(title);
        bookRepository.save(book);
        userRepository.save(user);

        Rental rental = new Rental(
                book,
                user,
                Date.valueOf(LocalDate.of(2018, 12, 3)),
                Date.valueOf(LocalDate.of(2019, 3, 3))
        );
        rentalRepository.save(rental);

        //When
        rentalRepository.delete(rental.getId());
        List<Rental> rentals = rentalRepository.findAll();
        int numberOfRentals = rentals.size();

        //Then
        Assert.assertEquals(initialNumberOfRentals, numberOfRentals);
        Assert.assertFalse(rentals.contains(rental));

        //CleanUp
//        userRepository.delete(user.getId());
//        bookRepository.delete(book.getId());
//        titleRepository.delete(title.getId());
    }
}