package edu.uha.miage.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping()
public class RootController {    
    
    @RequestMapping(path = {"", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }
    @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
    public String login() {       
        return "login";
    }
     @RequestMapping(path = {"/logout"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }
}
