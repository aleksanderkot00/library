package com.crud.library.domain;

import com.crud.library.repository.TitleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TitleTest {
    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void testSave() {
        //Given
        int initialNumberOfTitles= titleRepository.findAll().size();
        Title title1 = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Title title2 = new Title("Harry Potter", "J.K. Rowling", 2004);

        //When
        titleRepository.save(title1);
        titleRepository.save(title2);
        int numberOfTitles = titleRepository.findAll().size();

        List<Title> titles = titleRepository.findAll();

        //Then
        Assert.assertEquals(initialNumberOfTitles + 2, numberOfTitles);
        Assert.assertTrue(titles.contains(title1));

        //Clean-up
        titleRepository.delete(title1.getId());
        titleRepository.delete(title2.getId());
    }
}