package com.crud.library.domain;

import com.crud.library.repository.BookRepository;
import com.crud.library.repository.TitleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void testSave() {
        //Given
        Title title1 = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Title title2 = new Title("Harry Potter", "J.K. Rowling", 2004);

        titleRepository.save(title1);
        titleRepository.save(title2);

        int initialNumberOfBooks = bookRepository.findAll().size();
        Book book1 = new Book(BookStatus.AVAILABLE, title1);
        Book book2 = new Book(BookStatus.LOST, title1);
        Book book3 = new Book(BookStatus.DESTROYED, title2);

        //When
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        int numberOfBooks = bookRepository.findAll().size();

        //Then
        Assert.assertEquals(initialNumberOfBooks + 3, numberOfBooks);

        //Clean-up
        bookRepository.delete(book1.getId());
        bookRepository.delete(book2.getId());
        bookRepository.delete(book3.getId());

        titleRepository.delete(title1.getId());
        titleRepository.delete(title2.getId());
    }
}