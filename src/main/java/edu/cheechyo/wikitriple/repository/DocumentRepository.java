package edu.cheechyo.wikitriple.repository;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Spring JPA : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 * Repository.
 *
 * Created by Cheechyo on 2017. 6. 8..
 */
public interface DocumentRepository extends CrudRepository<Document,Integer> {
    Document findTopByTitleOrderByVersionDesc(String title);

    int countByTitle(String title);

    List<Document> findBytitleOrderByVersionDesc(String title);

    Document findByTitleAndVersion(String title, Integer version);

    void delete(Document document);

    List<Document> findAllByRegUser(User regUser);

    List<Document> findTop10ByOrderByRegDateDesc();
}
