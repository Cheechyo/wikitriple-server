package edu.cheechyo.wikitriple.services.impl;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.model.User;
import edu.cheechyo.wikitriple.repository.DocumentRepository;
import edu.cheechyo.wikitriple.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
@Component
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document findTopByTitleOrderByVersionDesc(String title) {
        return documentRepository.findTopByTitleOrderByVersionDesc(title);
    }

    @Override
    public int save(Document document) {
        int count = documentRepository.countByTitle(document.getTitle());
        document.setVersion(count);
        if (document.getRegDate() == null) {
            document.setRegDate(new Timestamp(System.currentTimeMillis()));
        }
        documentRepository.save(document);
        return count;
    }

    @Transactional
    @Override
    public void delete(Document aDocument) {
        documentRepository.delete(aDocument);
    }

    @Override
    public java.util.List<Document> findBytitleOrderByVersionDesc(String title) {
        return documentRepository.findBytitleOrderByVersionDesc(title);
    }

    @Override
    public Document findByTitleAndVersion(String title, Integer version) {
        return documentRepository.findByTitleAndVersion(title, version);
    }

    @Override
    public void saveWithUser(Document document, User loginedUser) {
        document.setRegUser(loginedUser);
        this.save(document);
    }

    @Override
    public List<Document> findByUserOrderByRegDateDesc(User savedUser) {
        return documentRepository.findAllByRegUserOrderByRegDateDesc(savedUser);
    }

    @Override
    public List<Document> findTop10ByOrderByRegDateDesc() {
        return documentRepository.findTop10ByOrderByRegDateDesc();
    }

}
