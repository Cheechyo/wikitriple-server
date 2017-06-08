package edu.cheechyo.wikitriple.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Cheechyo on 2017. 6. 8..
 */
@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", "heello");
        return "hello";
    }
}
