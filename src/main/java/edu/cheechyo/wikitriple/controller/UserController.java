package edu.cheechyo.wikitriple.controller;

import edu.cheechyo.wikitriple.model.User;
import edu.cheechyo.wikitriple.services.DocumentService;
import edu.cheechyo.wikitriple.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Cheechyo on 2017. 6. 15..
 */
@Controller
public class UserController {
    final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    DocumentService documentService;
    @PostMapping("/login")
    void login(HttpSession httpSession, @RequestParam String username, @RequestParam String password, @RequestParam(required = false)String loopBack) {
        final User aUser = new User();
        aUser.setUsername(username);
        aUser.setPassword(password);
        User savedUser = userService.findByUsernameAndPassword(username,password);
        if (savedUser != null && savedUser.getUserinfoId() != null) {
            httpSession.setAttribute("documentsByUser", documentService.findByUser(savedUser));
        }
        httpSession.setAttribute("loginedUser", savedUser);
    }

    @PostMapping("/signup")
    void signup(HttpSession httpSession, @RequestParam String username, @RequestParam String password, @RequestParam(required = false)String loopBack) {
        final User aUser = new User();
        aUser.setUsername(username);
        aUser.setPassword(password);
        if (userService.save(aUser)) {
            User savedUser = userService.findByUsernameAndPassword(username, password);
            httpSession.setAttribute("loginedUser", savedUser);
        } else {

        }
    }
    @GetMapping("/logout")
    void logout(HttpSession httpSession, @RequestParam(required = false)String loopBack) {
        final User loginedUser = (User) httpSession.getAttribute("loginedUser");
        if (loginedUser != null && loginedUser.getUserinfoId() != null){
            httpSession.setAttribute("loginedUser", null);
        }
    }
}
