package edu.cheechyo.wikitriple.repository;

import edu.cheechyo.wikitriple.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cheechyo on 2017. 6. 8..
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);

    void deleteByUsernameAndPassword(String username, String password);
}
