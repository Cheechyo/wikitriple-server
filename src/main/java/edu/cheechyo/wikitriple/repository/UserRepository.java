package edu.cheechyo.wikitriple.repository;

import edu.cheechyo.wikitriple.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Cheechyo on 2017. 6. 8..
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);

    void deleteAllByUsernameAndPassword(String username, String password);

    List<User> findByUsername(String username);
}
