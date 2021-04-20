package yucroq;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import yucroq.service.UserService;

@SpringBootApplication
@EnableWebSecurity // Autorise les annotations de sécurité sur les contrôleurs
@EnableGlobalMethodSecurity(securedEnabled = true)
@Slf4j
public class YucroqApp {
    
    final
    UserService userService;

    public YucroqApp(UserService userService) {
        this.userService = userService;
    }

	public static void main(String[] args) {
		SpringApplication.run(YucroqApp.class, args);
	}
   /* @PostConstruct
    // Quand on lance l'application, on crée un administrateur (cf. application.properties)
    private void initialize() {
        userService.initializeRolesAndAdmin();
    }
    */
}
