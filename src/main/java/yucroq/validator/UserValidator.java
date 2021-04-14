<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
package yucroq.validator;

import yucroq.entity.Proprietaire;
import yucroq.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
<<<<<<< HEAD
public class UserValidator implements Validator{
        private final UserService userService;
=======
public class UserValidator implements Validator {
    private final UserService userService;
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Proprietaire.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Proprietaire user = (Proprietaire) o;


        if (userService.findByUserName(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
