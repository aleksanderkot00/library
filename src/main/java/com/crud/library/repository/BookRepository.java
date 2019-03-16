package com.crud.library.repository;

import com.crud.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Book save(Book book);

    @Override
    List<Book> findAll();

    Optional<Book> findById(Long id);
}
