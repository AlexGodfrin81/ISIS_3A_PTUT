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
public class UserController {
    @GetMapping(path = "pageUser")
    public String montrePageUtilisateur(
        @AuthenticationPrincipal Proprietaire user,  // Les infos de l'utilisateur connecté
        Model model) {
        log.info("L'utilisateur id: {}, email: {} accède à sa page", user.getId_proprio(), user.getEmail());
        return "pageUser"; // On affiche la vue 'pageUser.html'
    }
}
