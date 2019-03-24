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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

//    @Transactional
    @Test
    public void testSaveAndFindAll() {
        //Given
        int initialNumberOfUsers = userRepository.findAll().size();
        User user1 = new User( "Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        User user2 = new User("Piotr", "Zielinski", Date.valueOf(LocalDate.of(2012,7,23)));
        User user3 = new User("Test", "User", Date.valueOf(LocalDate.of(1993,4,2)));

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        List<User> users = userRepository.findAll();
        int numberOfUsers = users.size();

        //Then
        Assert.assertEquals(initialNumberOfUsers + 3, numberOfUsers);
        Assert.assertTrue(users.contains(user1));
        Assert.assertTrue(users.contains(user2));
        Assert.assertTrue(users.contains(user3));

        //CleanUp
        userRepository.delete(user1.getId());
        userRepository.delete(user2.getId());
        userRepository.delete(user3.getId());
    }

    @Test
    public void testFindById() {
        //Given
        User user = new User( "Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        userRepository.save(user);

        //When
        User foundUser = userRepository.findById(user.getId()).get();

        //Then
        Assert.assertEquals(user, foundUser);

        //CleanUp
        userRepository.delete(user.getId());
    }

    @Test
    public void testDelete() {
        //Given
        int initialNumberOfUsers = userRepository.findAll().size();
        User user = new User( "Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        userRepository.save(user);

        //When
        userRepository.delete(user);
        List<User> users = userRepository.findAll();
        int numberOfUsers = users.size();

        //Then
        Assert.assertEquals(initialNumberOfUsers, numberOfUsers);
        Assert.assertFalse(users.contains(user));
    }

    @Test
    public void testDeleteById() {
        //Given
        int initialNumberOfUsers = userRepository.findAll().size();
        User user = new User( "Aleksander", "Kot", Date.valueOf(LocalDate.now()));
        userRepository.save(user);

        //When
        userRepository.delete(user.getId());
        List<User> users = userRepository.findAll();
        int numberOfUsers = users.size();

        //Then
        Assert.assertEquals(initialNumberOfUsers, numberOfUsers);
        Assert.assertFalse(users.contains(user));
    }
}