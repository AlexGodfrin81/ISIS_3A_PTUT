/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.controller;

import lombok.extern.slf4j.Slf4j;
import yucroq.entity.Proprietaire;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(path = "/user")
@Secured({"ROLE_ADMIN", "ROLE_USER"}) // Réservé aux utilisateurs qui ont le rôle 'ROLE_USER' ou 'ROLE_ADMIN'
public class ProprietaireController {
    @GetMapping(path = "pageUser")
    public String montrePageUtilisateur(
        @AuthenticationPrincipal Proprietaire user,  // Les infos de l'utilisateur connecté
        Model model) {
        log.info("L'utilisateur id: {}, email: {} accède à sa page", user.getId_proprio(), user.getEmail());
        return "detailProprio"; // On affiche la vue 'pageUser.html'
    }
}