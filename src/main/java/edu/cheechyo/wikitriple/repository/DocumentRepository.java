package edu.cheechyo.wikitriple.repository;

import edu.cheechyo.wikitriple.model.Document;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring JPA : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 * Repository.
 *
 * Created by Cheechyo on 2017. 6. 8..
 */
public interface DocumentRepository extends CrudRepository<Document,Integer> {
    Document findTopByTitleOrderByVersionDesc(String title);

    int countByTitle(String title);
}
