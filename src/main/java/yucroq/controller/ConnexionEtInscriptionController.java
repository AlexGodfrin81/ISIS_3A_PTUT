/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.controller;

import yucroq.entity.Proprietaire;
import yucroq.service.SecurityService;
import yucroq.service.UserService;
import yucroq.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ConnexionEtInscriptionController {
     private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    public ConnexionEtInscriptionController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @GetMapping("/inscription")
    public String registration(Model model) {
        model.addAttribute("userForm", new Proprietaire());

        return "inscription";
    }

    @PostMapping("/inscription")
    public String registration(@Valid @ModelAttribute("userForm") Proprietaire userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "inscription";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/accueil";
    }

    @GetMapping("/connexion")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect.");

        if (logout != null)
            model.addAttribute("message", "Vous avez été déconnecté.");

        return "connexion";
    }

    //première page 
    @GetMapping({"/", "/accueil"})
    public String welcome(Model model) {
        return "accueil";
    }
}
