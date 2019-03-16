package com.crud.library.repository;


import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

public interface TitleRepository extends CrudRepository<Title, Long> {
    @Override
    Title save(Title title);

    @Override
    List<Title> findAll();

    Optional<Title> findById(Long id);
}
