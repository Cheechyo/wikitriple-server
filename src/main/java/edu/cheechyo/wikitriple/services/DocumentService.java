package edu.cheechyo.wikitriple.services;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.model.User;

import java.util.List;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
public interface DocumentService{
    Document findTopByTitleOrderByVersionDesc(String title);

    int save(Document document);

    void delete(Document aDocument);

    List<Document> findBytitleOrderByVersionDesc(String title);

    Document findByTitleAndVersion(String title, Integer version);

    void saveWithUser(Document document, User loginedUser);
}
