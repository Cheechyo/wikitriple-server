package edu.cheechyo.wikitriple.controller;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.model.User;
import edu.cheechyo.wikitriple.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/document/{title}")
    public String read(Model model
            , @PathVariable String title
            , @SessionAttribute(required = false) User loginedUser
            , @SessionAttribute(required = false) List<Document> documentsByUser) {
        model.addAttribute("title", title);
        Document document = documentService.findTopByTitleOrderByVersionDesc(title);
        if (document != null) {
            model.addAttribute("content", document.getContent());
        } else {
            model.addAttribute("content", "문서가 없습니다.");
        }
        model.addAttribute("user", loginedUser);
        model.addAttribute("documentsByUser", documentsByUser);
        return "document";
    }

    @GetMapping("/document/{title}/{version}")
    public String readWithVersion(Model model
            , @PathVariable String title
            , @PathVariable String version
            , @SessionAttribute(required = false) User loginedUser
            , @SessionAttribute(required = false) List<Document> documentsByUser) {
        Document document = null;
        try {
            Integer versionNumber = Integer.parseInt(version);
            document = documentService.findByTitleAndVersion(title, versionNumber);
        } catch (NumberFormatException e) {
        }
        if (document == null) {
            document = documentService.findTopByTitleOrderByVersionDesc(title);
        }
        model.addAttribute("title", title);
        model.addAttribute("version", document.getVersion());
        model.addAttribute("content", document.getContent());
        model.addAttribute("user", loginedUser);
        model.addAttribute("documentsByUser", documentsByUser);
        return "document_withversion";
    }

    @GetMapping("/document/history/{title}")
    public String history(Model model, @PathVariable String title
            , @SessionAttribute(required = false) User loginedUser
            , @SessionAttribute(required = false) List<Document> documentsByUser) {
        List<Document> documents = documentService.findBytitleOrderByVersionDesc(title);
        model.addAttribute("title", title);
        model.addAttribute("revisions", documents);
        model.addAttribute("user", loginedUser);
        model.addAttribute("documentsByUser", documentsByUser);
        return "history";
    }

    @GetMapping("/document/search")
    public String search(Model model, @RequestParam String search_query
            , @SessionAttribute(required = false) User loginedUser
            , @SessionAttribute(required = false) List<Document> documentsByUser) {
        String title = search_query;
        model.addAttribute("title", title);
        Document document = documentService.findTopByTitleOrderByVersionDesc(title);
        if (document != null) {
            model.addAttribute("content", document.getContent());
        } else {
            model.addAttribute("content", "문서가 없습니다.");
        }
        model.addAttribute("user", loginedUser);
        model.addAttribute("documentsByUser", documentsByUser);
        return "search";
    }

    @GetMapping("/document/edit/{title}")
    public String edit(Model model, @PathVariable String title
            , @SessionAttribute(required = false) User loginedUser
            , @SessionAttribute(required = false) List<Document> documentsByUser) {
        Document document = documentService.findTopByTitleOrderByVersionDesc(title);
        model.addAttribute("title", title);
        if (document != null)
            model.addAttribute("content", document.getContent());
        else
            model.addAttribute("content", "마크다운 문법을 사용해서 내용을 채워주세요. \n\n 우측은 미리보기입니다.");
        model.addAttribute("user", loginedUser);
        model.addAttribute("documentsByUser", documentsByUser);
        return "edit";
    }

    @PostMapping(value = "/document/save")
    public String save(Model model
            , @ModelAttribute Document document
            , @SessionAttribute(required = false) User loginedUser) throws UnsupportedEncodingException {
        if (loginedUser == null) {
            documentService.save(document);
        } else {
            documentService.saveWithUser(document, loginedUser);
        }
        return "redirect:/document/" + URLEncoder.encode(document.getTitle(), "UTF-8");
    }

//    @ExceptionHandler(NullPointerException.class)
//    public String handleException(NullPointerException e) {
//        return "error";
//    }
}
