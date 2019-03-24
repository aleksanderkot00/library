package com.crud.library.repository;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookStatus;
import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Book save(Book book);

    @Override
    List<Book> findAll();

    List<Book> findAllByStatusAndTitle(BookStatus status, Title title);

    Optional<Book> findById(Long id);
}
