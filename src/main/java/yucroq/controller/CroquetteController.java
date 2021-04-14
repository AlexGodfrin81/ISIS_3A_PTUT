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
import yucroq.entity.Animal;
import yucroq.entity.Croquette;

/**
 *
 * @author ALEX
 */
@Controller
@RequestMapping(path = "/croquette")
public class CroquetteController {
    
    @Autowired
    private CroquetteRepository dao;
    @Autowired
    private AnimalRepository dao1;
    
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
    
    
    /**
     * Redirige vers la page d'un animal selon son id
     *
     * @param model pour transmettre les informations à la vue
     * @param id l'id de l'animal
     * @return le nom de la vue à afficher ('detailCroquettes.html')
     */
    @GetMapping(path = "getCroquette")
    public String afficheUneCroquette(Model model, Integer id) {
        model.addAttribute("croquette", dao.getOne(id));
        return "detailCroquettes";
    }
    
    
      /**
     * Montre le formulaire permettant d'ajouter une croquette
     *
     * @param croquette initialisé par Spring, valeurs par défaut à afficher dans le formulaire
     * @return le nom de la vue à afficher ('formulaireCroquette.html')
     */
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model) {     
        model.addAttribute("croquette", new Croquette());
        model.addAttribute("animal", dao1.findAll());
        return "formulaireCroquette";
    }
    /**
     * Appelé par 'formulaireCroquette.html', méthode POST
     *
     * @param croquette Une croquette initialisée avec les valeurs saisies dans le formulaire
     * @param redirectInfo pour transmettre des paramètres lors de la redirection
     * @return une redirection vers l'affichage de la liste des croquettes
     */
    @PostMapping(path = "save")
    public String ajouteLaGaleriePuisMontreLaListe(Croquette croquette, RedirectAttributes redirectInfo) {
        String message;
        try {
            // cf. https://www.baeldung.com/spring-data-crud-repository-save
            dao.save(croquette);
            // Le code de la catégorie a été initialisé par la BD au moment de l'insertion
            message = "La croquette '" + croquette.getNom() + "' a été correctement enregistrée";
        } catch (DataIntegrityViolationException e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : La croquette '" + croquette.getNom() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheCroquette.html'
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:show"; // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }
}
