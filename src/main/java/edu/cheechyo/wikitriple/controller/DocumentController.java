package edu.cheechyo.wikitriple.controller;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.repository.DocumentRepository;
import edu.cheechyo.wikitriple.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/document/{title}")
    public String document(Model model, @PathVariable String title) {
        Document document = documentService.findTopByTitleOrderByVersionDesc(title);
        model.addAttribute("title", title);
        model.addAttribute("content", document.getContent());
        return "document";
    }
    @GetMapping("/document/edit/{title}")
    public String edit(Model model, @PathVariable String title) {
        Document document = documentService.findTopByTitleOrderByVersionDesc(title);
        model.addAttribute("title", title);
        model.addAttribute("content", document.getContent());
        return "edit";
    }

    @PostMapping(value = "/document/save")
    public String save(Model model, @ModelAttribute Document document) {
        documentService.save(document);
        return "redirect:/document/" + document.getTitle();
    }

}
