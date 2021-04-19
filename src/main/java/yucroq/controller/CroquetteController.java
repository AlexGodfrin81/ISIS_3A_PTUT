/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yucroq.dao.AnimalRepository;
import yucroq.dao.CroquetteRepository;
import yucroq.entity.Animal;
import yucroq.entity.Croquette;
import yucroq.entity.Proprietaire;

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
     * @param id l'id de l'animal concerné
     * @param user l'utilisateur connecté (un propriétaire)
     * @return le nom de la vue à afficher ('afficheGTableaux.html')
     */
    @GetMapping(path = "show")
    public String afficheToutesLesCroquettes(Model model, Integer id,  @AuthenticationPrincipal Proprietaire user) {
        model.addAttribute("croquettes", dao.findAll());   
        model.addAttribute("croquette", dao.listeCroquettesPour(id));
        model.addAttribute("animal", dao1.getOne(id));
        model.addAttribute("listeanimaux", dao.listeAnimaux(id));
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
    public String afficheUneCroquette(Model model, Integer idcroq, Integer idanimal) {
        model.addAttribute("croquette", dao.getOne(idcroq));
        model.addAttribute("animal", dao1.getOne(idanimal));
        model.addAttribute("listeanimaux", dao.listeAnimaux(idanimal));
        return "detailCroquettes";
    }
    
    /**
     * Redirige vers la liste des croquettes selon la recherche effectuée
     *
     * @param model pour transmettre les informations à la vue
     * @param id l'id de l'animal
     * @param recherche le contenu de la recherche
     * @return le nom de la vue à afficher ('detailCroquettes.html')
     */
    @GetMapping(path = "searchCroquettes")
    public String afficheUneCroquette(Model model, String recherche, Integer idanimal) {
        model.addAttribute("recherche", dao.rechercheCroquettes(recherche));
        model.addAttribute("animal", dao1.getOne(idanimal));
        model.addAttribute("listeanimaux", dao.listeAnimaux(idanimal));
        return "rechercheCroquettes";
    }

      /**
     * Montre le formulaire permettant d'ajouter une croquette
     *
     * @param croquette initialisé par Spring, valeurs par défaut à afficher dans le formulaire
     * @return le nom de la vue à afficher ('formulaireCroquette.html')
     */
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model, Integer id) {     
        model.addAttribute("croquette", new Croquette());
        model.addAttribute("animal", dao1.findById(id));
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
    public String ajouteLaCroquettePuisFormulaireRation(Croquette croquette, Integer id, RedirectAttributes redirectInfo) {
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
        return "redirect:/ration/add?id="+id; // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }
     @GetMapping(path = "delete")
    public String supprimerCroquette(@RequestParam("id") Croquette croquette, RedirectAttributes redirectInfo) {
        String message = croquette.getNom() + "' a été supprimé";
        try {
            dao.delete(croquette);
        } catch (DataIntegrityViolationException e) {
            message = "Erreur : impossible de supprimer " + croquette.getNom();
        }
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:show";
    }

}
