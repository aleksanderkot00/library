package com.crud.library.domain;

import com.crud.library.repository.BookRepository;
import com.crud.library.repository.TitleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Transactional
    @Test
    public void testSaveAndFindAll() {
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
        List<Book> books = bookRepository.findAll();
        int numberOfBooks = books.size();

        //Then
        Assert.assertEquals(initialNumberOfBooks + 3, numberOfBooks);
        Assert.assertTrue(books.contains(book1));
        Assert.assertTrue(books.contains(book2));
        Assert.assertTrue(books.contains(book3));

        //CleanUp
//        bookRepository.delete(book1.getId());
//        bookRepository.delete(book2.getId());
//        bookRepository.delete(book3.getId());
//        titleRepository.delete(title1.getId());
//        titleRepository.delete(title2.getId());
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        titleRepository.save(title);

        Book book = new Book(BookStatus.AVAILABLE, title);
        bookRepository.save(book);

        //When
        Book foundBook = bookRepository.findById(book.getId()).get();

        //Then
        Assert.assertEquals(book, foundBook);

        //CleanUp
//        bookRepository.delete(book.getId());
//        titleRepository.delete(title.getId());
    }

    @Transactional
    @Test
    public void testFindByStatusAnsTitle() {
        //Given
        Title title1 = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Title title2 = new Title("Harry Potter", "J.K. Rowling", 2004);
        titleRepository.save(title1);
        titleRepository.save(title2);

        Book book1 = new Book(BookStatus.AVAILABLE, title1);
        Book book2 = new Book(BookStatus.AVAILABLE, title1);
        Book book3 = new Book(BookStatus.DESTROYED, title1);
        Book book4 = new Book(BookStatus.LOST, title2);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);

        //When
        List<Book> books1 = bookRepository.findAllByStatusAndTitle(BookStatus.AVAILABLE, title1);
        List<Book> books2 = bookRepository.findAllByStatusAndTitle(BookStatus.DESTROYED, title1);
        List<Book> books3 = bookRepository.findAllByStatusAndTitle(BookStatus.LOST, title2);
        List<Book> books4 = bookRepository.findAllByStatusAndTitle(BookStatus.AVAILABLE, title2);

        //Then
        Assert.assertTrue(books1.contains(book1));
        Assert.assertTrue(books1.contains(book2));
        Assert.assertTrue(books2.contains(book3));
        Assert.assertTrue(books3.contains(book4));
        Assert.assertFalse(books1.contains(book4));
        Assert.assertFalse(books4.contains(book2));

        //CleanUp
        bookRepository.delete(book1.getId());
        bookRepository.delete(book2.getId());
        bookRepository.delete(book3.getId());
        bookRepository.delete(book4.getId());
        titleRepository.delete(title1.getId());
        titleRepository.delete(title2.getId());
    }

    @Transactional
    @Test
    public void testDelete() {
        //Given
        int initialNumberOfBooks = bookRepository.findAll().size();
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        titleRepository.save(title);
        Book book = new Book(BookStatus.AVAILABLE, title);
        bookRepository.save(book);

        //When
        bookRepository.delete(book);
        List<Book> books = bookRepository.findAll();
        int numberOfBooks = books.size();

        //Then
        Assert.assertEquals(initialNumberOfBooks, numberOfBooks);
        Assert.assertFalse(books.contains(book));

        //CleanUp
//        titleRepository.delete(title.getId());
    }

    @Transactional
    @Test
    public void testDeleteById() {
        //Given
        int initialNumberOfBooks = bookRepository.findAll().size();
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        titleRepository.save(title);
        Book book = new Book(BookStatus.AVAILABLE, title);
        bookRepository.save(book);

        //When
        bookRepository.delete(book.getId());
        List<Book> books = bookRepository.findAll();
        int numberOfBooks = books.size();

        //Then
        Assert.assertEquals(initialNumberOfBooks, numberOfBooks);
        Assert.assertFalse(books.contains(book));

        //CleanUp
//        titleRepository.delete(title.getId());
    }
}