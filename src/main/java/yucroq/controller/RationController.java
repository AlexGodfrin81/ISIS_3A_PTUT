/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yucroq.dao.AnimalRepository;
import yucroq.dao.CroquetteRepository;
import yucroq.dao.RationRepository;
import yucroq.entity.Croquette;
import yucroq.entity.Ration;

/**
 *
 * @author ALEX
 */
@Controller
@RequestMapping(path = "/ration")
public class RationController {
    
    @Autowired
    private RationRepository dao1;
    @Autowired
    private AnimalRepository dao2;
    @Autowired
    private CroquetteRepository dao3;
    
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model, Integer id) {   
        model.addAttribute("ration", new Ration());
        model.addAttribute("animal", dao2.getOne(id));
        model.addAttribute("croquettes", dao3.findAll());
        return "formulaireRation";
    }
    
    @PostMapping(path = "save")
    public String ajouteLaGaleriePuisMontreLaListe(Ration ration, RedirectAttributes redirectInfo) {
        String message;
        try {
            // cf. https://www.baeldung.com/spring-data-crud-repository-save
            dao1.save(ration);
            // Le code de la catégorie a été initialisé par la BD au moment de l'insertion
            message = "La ration '" + ration.getId_ration()+ "' a été correctement enregistrée";
        } catch (DataIntegrityViolationException e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : La ration '" + ration.getId_ration() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheCroquette.html'
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:/animal/show"; // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }
}
