package edu.cheechyo.wikitriple.services.impl;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.services.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Mokito, Hamcrest, Junit을 사용한 테스트
 * 참조 :
 *  테스트 관련
 * http://bestalign.github.io/2016/07/08/intro-mockito-1/
 * https://gojko.net/2009/10/23/mockito-in-six-easy-examples/
 * https://www.lesstif.com/pages/viewpage.action?pageId=18219426
 *
 *  스프링 관련
 * https://stackoverflow.com/questions/38711871/load-different-application-yml-in-springboot-test
 *
 * Created by Cheechyo on 2017. 6. 9..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DocumentServiceImplTest {
    @Autowired
    DocumentService documentService;

    @Test
    public void save() throws Exception {
        Document documentOne = new Document();
        documentOne.setTitle("_savetest");
        documentOne.setContent("Content of savetest1");
        Document documentTwo = new Document();
        documentTwo.setTitle(documentOne.getTitle());
        documentTwo.setContent("Content of savetest2");

        documentService.save(documentOne);
        documentOne = documentService.findTopByTitleOrderByVersionDesc(documentOne.getTitle());
        documentService.save(documentTwo);
        documentTwo = documentService.findTopByTitleOrderByVersionDesc(documentTwo.getTitle());

        Date d = new Date(System.currentTimeMillis());
        assertThat(documentOne.getVersion()+1, is(documentTwo.getVersion()));
        assertThat(Math.abs(documentOne.getRegDate().compareTo(d)), lessThan(3000));
        assertThat(Math.abs(documentTwo.getRegDate().compareTo(d)), lessThan(3000));
        documentService.delete(documentOne);
        documentService.delete(documentTwo);
    }

    @Test
    public void findByTitleOrderByVersionDesc() throws Exception {
        Document documentOne = new Document();
        documentOne.setTitle("_findByTitleOrderByVersionDesctest");
        documentOne.setContent("Content of " + documentOne.getTitle());
        Document documentTwo = new Document();
        documentTwo.setTitle(documentOne.getTitle());
        documentTwo.setContent("Content of " + documentTwo.getTitle() + "2");

        documentService.save(documentOne);
        documentService.save(documentTwo);
        List<Document> list = documentService.findBytitleOrderByVersionDesc(documentOne.getTitle());
        assertThat(list.size(), greaterThanOrEqualTo(2));
        documentService.delete(documentOne);
        documentService.delete(documentTwo);
    }

    @Test
    public void saveOne() throws Exception {
        final Document aDocument = new Document();
        aDocument.setTitle("_saveOneTest");
        aDocument.setContent("Content of saveOneTest");
        documentService.save(aDocument);

        final Document findedDocument = documentService.findTopByTitleOrderByVersionDesc(aDocument.getTitle());
        assertThat(findedDocument.getTitle(), is(aDocument.getTitle()));
        assertThat(findedDocument.getContent(), is(aDocument.getContent()));
        assertThat(findedDocument.getVersion(), not(nullValue()));
        documentService.delete(findedDocument);
    }

    @Test
    public void deleteOne() throws  Exception {
        final Document aDocument = new Document();
        aDocument.setTitle("_deleteOneTest");
        aDocument.setContent("Content of _deleteOneTest");


        final Document oldDocument = documentService.findTopByTitleOrderByVersionDesc(aDocument.getTitle());
        documentService.save(aDocument);
        if (oldDocument == null){
            assertThat(documentService.findTopByTitleOrderByVersionDesc(aDocument.getTitle()), is(notNullValue()));
            documentService.delete(aDocument);
            assertThat(documentService.findTopByTitleOrderByVersionDesc(aDocument.getTitle()), is(nullValue()));
        }
        else {
            documentService.delete(aDocument);
            assertThat(documentService.findTopByTitleOrderByVersionDesc(aDocument.getTitle()).getVersion(), is(oldDocument.getVersion()));
        }

    }

    @Test
    public void findDocumentByUser(){
        // TODO 테스트 작성해야됨
        final String title = "_findDocumentByUser test";
        Document documentOne = new Document();
        documentOne.setTitle(title);
        documentOne.setContent("Content of " + title);
        Document documentTwo = new Document();
        documentTwo.setTitle(title);
        documentTwo.setContent("Content of " + title + "2");

        documentService.save(documentOne);
        documentOne = documentService.findTopByTitleOrderByVersionDesc(documentOne.getTitle());
        documentService.save(documentTwo);
        documentTwo = documentService.findTopByTitleOrderByVersionDesc(documentTwo.getTitle());

        Date d = new Date(System.currentTimeMillis());
        assertThat(documentOne.getVersion()+1, is(documentTwo.getVersion()));
        assertThat(Math.abs(documentOne.getRegDate().compareTo(d)), lessThan(3000));
        assertThat(Math.abs(documentTwo.getRegDate().compareTo(d)), lessThan(3000));

        documentService.delete(documentOne);
        documentService.delete(documentTwo);
    }
    @Test
    public void find10ByRegDateDesc(){
        // TODO 테스트 작성해야됨
    }
}