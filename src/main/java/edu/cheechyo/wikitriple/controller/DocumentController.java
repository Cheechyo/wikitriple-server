package edu.cheechyo.wikitriple.controller;

import edu.cheechyo.wikitriple.model.Document;
import edu.cheechyo.wikitriple.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Cheechyo on 2017. 6. 9..
 */
@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/document/{title}")
    public String read(Model model, @PathVariable String title) {
        Document document = documentService.findTopByTitleOrderByVersionDesc(title);
        model.addAttribute("title", title);
        model.addAttribute("content", document.getContent());
        return "document";
    }

    @GetMapping("/document/{title}/{version}")
    public String readWithVersion(Model model, @PathVariable String title, @PathVariable String version) {
        Document document = null;
        try {
            Integer versionNumber = Integer.parseInt(version);
            document = documentService.findByTitleAndVersion(title, versionNumber);
            model.addAttribute("title", String.format("%s (%d)", title, versionNumber));
        } catch (NumberFormatException e) {
        }
        if (document == null) {
            document = documentService.findTopByTitleOrderByVersionDesc(title);
            model.addAttribute("title", title);
        }
        model.addAttribute("content", document.getContent());
        return "document";
    }

    @GetMapping("/document/search")
    public String search(Model model, @RequestParam String search_query) {
        model.addAttribute("title", search_query);
        Document document = documentService.findTopByTitleOrderByVersionDesc(search_query);
        if (document != null) {
            model.addAttribute("content", document.getContent());
        } else {
            model.addAttribute("content", "not founded.");
        }
        return "search";
    }

    @GetMapping("/document/edit/{title}")
    public String edit(Model model, @PathVariable String title) {
        Document document = documentService.findTopByTitleOrderByVersionDesc(title);
        model.addAttribute("title", title);
        if (document != null)
            model.addAttribute("content", document.getContent());
        else
            model.addAttribute("content", "not founded.");
        return "edit";
    }

    @PostMapping(value = "/document/save")
    public String save(Model model, @ModelAttribute Document document) {
        documentService.save(document);
        return "redirect:/document/" + document.getTitle();
    }

}
