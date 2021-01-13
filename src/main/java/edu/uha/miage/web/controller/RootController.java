package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.service.CompteService;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping()
public class RootController {

    @Autowired
    CompteService compteService;

    @RequestMapping(path = {"", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        Personne userPersonne = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne();

        model.addAttribute("user", userPersonne);
        model.addAttribute("date", new Date());
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
