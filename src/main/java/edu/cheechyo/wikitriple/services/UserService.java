package edu.cheechyo.wikitriple.services;

import edu.cheechyo.wikitriple.model.User;

/**
 * Created by Cheechyo on 2017. 6. 15..
 */
public interface UserService {
    User findByUsernameAndPassword(String username, String password);

    boolean save(User aUser);

    void delete(User aUser);

    void deleteByUsernameAndPassword(String username, String password);
}
