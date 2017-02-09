package com.ironyard.controller;

import com.ironyard.data.MovieUser;
import com.ironyard.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by jasonskipper on 2/6/17.
 */
@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(path = "/open/authenticate", method = RequestMethod.POST)
    public String login(HttpSession session, Model data, @RequestParam(name = "username") String usr, @RequestParam String password){
        logger.trace("Starting login...");
        String destinationView = "home";
            MovieUser found = userRepo.findByUsernameAndPassword(usr, password);
            if(found.getDisplayName().equals("jason")){
                // extra for jason
            }
            if (found == null) {
                // no user found, login must fail
                logger.warn("User failed attempted login:" + usr);
                destinationView = "login";
                data.addAttribute("message", "User/Pass combination not found.");
            } else {
                logger.debug("Successful login for:" + usr);
                session.setAttribute("user", found);
                destinationView = "redirect:/secure/movies";
            }
        logger.trace("Ending login...");
        return destinationView;
    }
}
