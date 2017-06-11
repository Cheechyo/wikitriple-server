package edu.cheechyo.wikitriple.services.impl;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.services.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DocumentServiceImplTest {
    @Autowired
    DocumentService documentService;

    @Test
    public void save() throws Exception {
        Document documentOne = new Document();
        documentOne.setTitle("_test");
        documentOne.setContent("Content of test");
        Document documentTwo = new Document();
        documentTwo.setTitle(documentOne.getTitle());
        documentTwo.setContent("Content of test2");

        documentService.save(documentOne);
        documentOne = documentService.findTopByTitleOrderByVersionDesc(documentOne.getTitle());
        documentService.save(documentTwo);
        documentTwo = documentService.findTopByTitleOrderByVersionDesc(documentTwo.getTitle());

        assertEquals(new Long(documentOne.getVersion() + 1), new Long(documentTwo.getVersion()));
    }
}