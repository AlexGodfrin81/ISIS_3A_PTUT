/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yucroq.dao.CroquetteRepository;

/**
 *
 * @author ALEX
 */
@Controller
@RequestMapping(path = "/croquette")
public class CroquetteController {
    
    @Autowired
    private CroquetteRepository dao;
    
    /**
     * Affiche toutes les catégories dans la base
     *
     * @param model pour transmettre les informations à la vue
     * @return le nom de la vue à afficher ('afficheGTableaux.html')
     */
    @GetMapping(path = "show")
    public String afficheToutesLesCroquettes(Model model) {
        model.addAttribute("croquettes", dao.findAll());
        return "afficheCroquettes";
    }
    
}
