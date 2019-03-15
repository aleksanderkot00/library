package com.crud.library.domain;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

//    @Transactional
    @Test
    public void testSave() {
        //Given
        int initialUserNumber = userRepository.findAll().size();
        Date date1 = Date.valueOf(LocalDate.now());
        Date date2 = Date.valueOf(LocalDate.of(2012,7,23));
        User user1 = new User( "Aleksander", "Kot", date1);
        User user2 = new User("Piotr", "Zielinski", date2);

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        int userNumber = userRepository.findAll().size();

        //Then
        Assert.assertEquals(initialUserNumber + 2, userNumber);

        //Clean-up
        userRepository.delete(user1.getId());
        userRepository.delete(user2.getId());
    }
}