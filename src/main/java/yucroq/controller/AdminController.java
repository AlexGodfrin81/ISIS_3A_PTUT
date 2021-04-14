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
@RequestMapping(path = "/admin")
@Secured("ROLE_ADMIN") // Réservé aux utilisateurs qui ont le rôle 'ROLE_ADMIN'
public class AdminController {
    @GetMapping(path = "pageAdmin")
    public String montreLaPageAdmin(@AuthenticationPrincipal Proprietaire user,  // Les infos de l'utilisateur connecté
                                    Model model) {
        log.info("L'administrateur id: {}, email: {} accède à sa page", user.getId_proprio(), user.getEmail());
<<<<<<< HEAD
        return "detailAdmin"; // On affiche la vue 'detailAdmin.html'
    }
}
=======
        return "pageAdmin"; // On affiche la vue 'pageAdmin.html'
    }
}
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
