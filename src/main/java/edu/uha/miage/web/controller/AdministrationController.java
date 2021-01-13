package edu.uha.miage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author victo
 */
@Controller
@RequestMapping("/administration")
public class AdministrationController {
    @RequestMapping(method = RequestMethod.GET)
    public String go() {
        return "administration";
    }
}
