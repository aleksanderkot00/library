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
    public void testSaveAndFindAll() {
        //Given
        int initialNumberOfTitles= titleRepository.findAll().size();
        Title title1 = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        Title title2 = new Title("Harry Potter", "J.K. Rowling", 2004);

        //When
        titleRepository.save(title1);
        titleRepository.save(title2);
        List<Title> titles = titleRepository.findAll();
        int numberOfTitles = titles.size();

        //Then
        Assert.assertEquals(initialNumberOfTitles + 2, numberOfTitles);
        Assert.assertTrue(titles.contains(title1));
        Assert.assertTrue(titles.contains(title2));

        //CleanUp
        titleRepository.delete(title1.getId());
        titleRepository.delete(title2.getId());
    }

    @Test
    public void testFindById() {
        //Given
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        titleRepository.save(title);

        //When
        Title foundTitle = titleRepository.findById(title.getId()).get();

        //Then
        Assert.assertEquals(title, foundTitle);

        //CleanUp
        titleRepository.delete(title.getId());
    }

    @Test
    public void testDelete() {
        //Given
        int initialNumberOfTitles = titleRepository.findAll().size();
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        titleRepository.save(title);

        //When
        titleRepository.delete(title);
        List<Title> titles = titleRepository.findAll();
        int numberOfTitles = titles.size();

        //Then
        Assert.assertEquals(initialNumberOfTitles, numberOfTitles);
        Assert.assertFalse(titles.contains(title));
    }

    @Test
    public void testDeleteById() {
        //Given
        int initialNumberOfTitles = titleRepository.findAll().size();
        Title title = new Title("The Lord of the Rings", "J. R. R. Tolkien", 2001);
        titleRepository.save(title);

        //When
        titleRepository.delete(title.getId());
        List<Title> titles = titleRepository.findAll();
        int numberOfTitles = titles.size();

        //Then
        Assert.assertEquals(initialNumberOfTitles, numberOfTitles);
        Assert.assertFalse(titles.contains(title));
    }
}