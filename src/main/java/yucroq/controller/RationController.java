/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.controller;

import java.time.LocalDate;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yucroq.dao.AnimalRepository;
import yucroq.dao.CroquetteRepository;
import yucroq.dao.ProprietaireRepository;
import yucroq.dao.RationRepository;
import yucroq.entity.Proprietaire;
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
    @Autowired
    private ProprietaireRepository dao4;

    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model, Integer id, @AuthenticationPrincipal Proprietaire user) {
        model.addAttribute("ration", new Ration());
        model.addAttribute("animal", dao2.getOne(id));
        model.addAttribute("croquette", dao3.listeCroquettesPour(id));
        model.addAttribute("croquettes", dao3.findAll());
        model.addAttribute("animaux", dao4.getOne(user.getId_proprio()).getMesAnimaux());
        return "formulaireRation";
    }

    @GetMapping(path = "update")
    public String montreLeFormulairePourModification(Model model, Integer idration, @AuthenticationPrincipal Proprietaire user) {
        model.addAttribute("ration", dao1.getOne(idration));
        model.addAttribute("animaux", dao4.getOne(user.getId_proprio()).getMesAnimaux());
        return "formulaireRationModification";
    }

    @PostMapping(path = "save")
    public String ajouteLaRationPuisMontreLaListe(Ration ration, RedirectAttributes redirectInfo) {
        String message;
        try {
            // cf. https://www.baeldung.com/spring-data-crud-repository-save
            dao1.save(ration);
            final Integer idration = ration.getId_ration();
            final LocalDate datedebut = ration.getDate_debut();
            dao1.updateRationDebut(datedebut, idration);
            // Le code de la catégorie a été initialisé par la BD au moment de l'insertion
            message = "La ration '" + ration.getId_ration() + "' a été correctement enregistrée";
        } catch (DataIntegrityViolationException e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : La ration '" + ration.getId_ration() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheCroquette.html'
        redirectInfo.addFlashAttribute("message", message);
        final Integer idanimal = ration.getConsommateur().getId_animal();
        final String lien = "redirect:/animal/getAnimal?id=" + idanimal;
        return lien; // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }

    /**
     * Fonction qui modifie la date de fin d'une ration ration puis qui redirige
     * sur la liste des animaux
     *
     * @param ration la ration modifé
     * @param redirectInfo permet de transmettre des informations lors d'une
     * redirection
     * @return la redirection
     */
    @PostMapping(path = "saveupdate")
    public String modifieLaRationPuisMontreLaListe(Ration ration, RedirectAttributes redirectInfo) {
        String message;
        try {
            dao1.updateRationFin(ration.getDate_fin(), ration.getId_ration());//, ration.getDate_fin());
            message = "La ration '" + ration.getId_ration() + "' a été correctement modifiée";
        } catch (Exception e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur sur la ration '" + ration.getId_ration();
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:/animal/show"; // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }
}
