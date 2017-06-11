package edu.cheechyo.wikitriple.services;

import edu.cheechyo.wikitriple.model.Document;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
public interface DocumentService{
    Document findTopByTitleOrderByVersionDesc(String title);

    int save(Document document);

    void delete(Document aDocument);
}
