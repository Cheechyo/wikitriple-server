package edu.cheechyo.wikitriple.services.impl;

import edu.cheechyo.wikitriple.model.User;
import edu.cheechyo.wikitriple.repository.UserRepository;
import edu.cheechyo.wikitriple.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Created by Cheechyo on 2017. 6. 15..
 */
@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean save(User aUser) {
        final List<User> savedUser = userRepository.findByUsername(aUser.getUsername());
        if (savedUser == null || savedUser.size() == 0) {
            userRepository.save(aUser);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void delete(User aUser) {
        userRepository.delete(aUser);
    }

    @Override
    public void deleteByUsernameAndPassword(String username, String password) {
        userRepository.deleteByUsernameAndPassword(username, password);
    }
}
