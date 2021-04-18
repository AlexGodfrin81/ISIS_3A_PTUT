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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yucroq.dao.ActiviteRepository;
import yucroq.dao.AnimalRepository;
import yucroq.dao.CroquetteRepository;
import yucroq.dao.ProprietaireRepository;
import yucroq.dao.RaceRepository;
import yucroq.dao.RationRepository;
import yucroq.dao.StadePhysiologiqueRepository;

/**
 *
 * @author leand
 */
@Controller
@RequestMapping(path = "/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository dao;

    @Autowired
    private CroquetteRepository dao1;

    @Autowired
    private ProprietaireRepository dao2;

    @Autowired
    private RaceRepository dao3;

    @Autowired
    private ActiviteRepository dao4;

    @Autowired
    private StadePhysiologiqueRepository dao5;

    @Autowired
    private RationRepository dao6;

    /**
     * Affiche toutes les catégories dans la base
     *
     * @param model pour transmettre les informations à la vue
     * @return le nom de la vue à afficher ('afficheGTableaux.html')
     */
    @GetMapping(path = "show")
    public String afficheTousLesAnimaux(Model model) {
        model.addAttribute("animaux", dao.findAll());
        return "afficheAnimaux";
    }

    /**
     * Redirige vers la page d'un animal selon son id
     *
     * @param model pour transmettre les informations à la vue
     * @param id l'id de l'animal
     * @return le nom de la vue à afficher ('afficheAnimal.html')
     */
    @GetMapping(path = "getAnimal")
    public String afficheUnAnimal(Model model, Integer id) {
        model.addAttribute("animal", dao.getOne(id));
        model.addAttribute("rations", dao.listeRationsPour(id));
        model.addAttribute("pesees", dao.listePeseesPour(id));
        return "detailAnimaux";
    }

    /**
     * Montre le formulaire permettant d'ajouter un animal
     *
     * @param animal initialisé par Spring, valeurs par défaut à afficher dans
     * le formulaire
     * @return le nom de la vue à afficher ('formulaireAnimal.html')
     */
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model, String name) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("croquettes", dao1.findAll());
        model.addAttribute("proprio", dao2.findByUsername(name));
        model.addAttribute("races", dao3.findAll());
        model.addAttribute("activites", dao4.findAll());
        model.addAttribute("stadephysios", dao5.findAll());
        model.addAttribute("rations", dao6.findAll());
        return "formulaireAnimal";
    }

    /**
     * Appelé par 'formulaireAnimal.html', méthode POST
     *
     * @param animal initialisée avec les valeurs saisies dans le formulaire
     * @param redirectInfo pour transmettre des paramètres lors de la
     * redirection
     * @return une redirection vers l'affichage de la liste des animaux
     */
    @PostMapping(path = "save")
    public String ajouteAnimalPuisMontreLaListe(Animal animal, RedirectAttributes redirectInfo) {
        String message;
        try {
            dao.save(animal);
            // Le code de la catégorie a été initialisé par la BD au moment de l'insertion
            message = "L'animal '" + animal.getNom() + "' a été correctement enregistrée";
        } catch (DataIntegrityViolationException e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : L'animal '" + animal.getNom() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheAnimal.html'
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:show"; // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }

    @GetMapping(path = "delete")
    public String supprimerAnimal(@RequestParam("id") Animal animal, RedirectAttributes redirectInfo) {
        String message = animal.getNom() + "' a été supprimé";
        try {
            dao.delete(animal);
        } catch (DataIntegrityViolationException e) {
            message = "Erreur : impossible de supprimer " + animal.getNom();
        }
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:show";
    }

}
