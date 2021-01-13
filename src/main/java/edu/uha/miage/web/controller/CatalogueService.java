package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Categorie;
import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.service.CategorieService;
import edu.uha.miage.core.service.ServiceService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author quentin
 */
@Controller
public class CatalogueService {

    @Autowired
    ServiceService serviceService;

    @Autowired
    CategorieService categorieSvc;

    
    @GetMapping("/catalogue")
    public String viewListCategory2(Model model) {

        model.addAttribute("categories", categorieSvc.findByParent(null));

        return "catalogue/list";
    }

    @RequestMapping(value = "/child/{id}", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String viewListChild(@PathVariable("id") Long id, HttpServletResponse response) {
        List<Categorie> list = categorieSvc.findById(id).get().getEnfants();

        return explodeListOfCategory(list);
    }

    @RequestMapping(value = "/catalogue/services/{id}", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String viewListServices(@PathVariable("id") Long id) {
        List<Services> list = serviceService.findByCategorie(categorieSvc.findById(id).get());
        return explodeListOfService(list);
    }

    // Passe de ["Categorie1", "Categorie2"] a "Categorie1,Categorie2"
    private String explode(List<String> arr) {
        String result = "";
        for (int i = 0; i < arr.size() - 1; i++) {
            result += arr.get(i) + ",";
        }

        return result + arr.get(arr.size() - 1);
    }

    private String explodeListOfCategory(List<Categorie> arr) {
        if (arr.size() > 0) {
            String result = "[";
            for (int i = 0; i < arr.size() - 1; i++) //result += "{id:"+arr.get(i).getId()+ ", libelle : "+arr.get(i).getLibelle()+"}," ;
            {
                result += arr.get(i).toJson() + ",";
            }
            //return result + "{id:"+arr.get(arr.size()-1).getId()+ ", libelle : "+arr.get(arr.size()-1).getLibelle()+"}]" ;
            return result + arr.get(arr.size() - 1).toJson() + "]";
        } else {
            return "[]";
        }
    }

    private String explodeListOfService(List<Services> arr) {
        if (arr.size() > 0) {
            String result = "[";
            for (int i = 0; i < arr.size() - 1; i++) {
                result += arr.get(i).toJson() + ",";
            }

            return result + arr.get(arr.size() - 1).toJson() + "]";
        } else {
            return "[]";
        }

    }
}
