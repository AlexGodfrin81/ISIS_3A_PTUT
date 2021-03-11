/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import yucroq.entity.Animal;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author leand
 */
@Controller
@RequestMapping(path = "/animal")
public class AnimalController {
    
    @Autowired
    private AnimalRepository dao;
    
    /**
     * Affiche toutes les catégories dans la base
     *
     * @param model pour transmettre les informations à la vue
     * @return le nom de la vue à afficher ('afficheGTableaux.html')
     */
    @GetMapping(path = "show")
    public String afficheTousLesAnimaux(Model model) {
        model.addAttribute("animal", dao.findAll());
        return "afficheAnimaux";
    }
    
}
