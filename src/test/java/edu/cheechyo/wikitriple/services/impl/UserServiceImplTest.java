package edu.cheechyo.wikitriple.services.impl;

import edu.cheechyo.wikitriple.model.User;
import edu.cheechyo.wikitriple.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Cheechyo on 2017. 6. 15..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void findByUsernameAndPassword() throws Exception {
        final String username = "_TESTUSER";
        final String password = "password";
        final User aUser = new User();
        aUser.setUsername(username);
        aUser.setPassword(password);
        if (userService.save(aUser)) {
            User savedUser = userService.findByUsernameAndPassword(username, password);
            assertThat(aUser.getUsername(), is(savedUser.getUsername()));
            assertThat(aUser.getPassword(), is(savedUser.getPassword()));
            userService.delete(savedUser);
        } else {
            User savedUser = userService.findByUsernameAndPassword(username, password);
            userService.delete(savedUser);
            throw new Exception();
        }
    }

}