package yucroq.service;

import lombok.extern.slf4j.Slf4j;
import yucroq.dao.RoleRepository;
<<<<<<< HEAD
=======
import yucroq.dao.UserRepository;
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
import yucroq.entity.Role;
import yucroq.entity.Proprietaire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import yucroq.dao.ProprietaireRepository;
=======
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97

@Service
@Slf4j
public class UserServiceImpl implements UserService {

<<<<<<< HEAD
    private final ProprietaireRepository userRepository;
=======
    private final UserRepository userRepository;
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    // Login et Password de l'administrateur son définis dans 'application.properties'
    @Value("${admin.username}")
<<<<<<< HEAD
    private String adminLogin;
=======
    private String adminUsername;
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
    @Value("${admin.password}")
    private String adminPassword;
    @Value("${admin.email}")
    private String adminEmail;
<<<<<<< HEAD

    public UserServiceImpl(ProprietaireRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
=======
    @Value("${admin.prenom}")
    private String adminPrenom;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(Proprietaire user) {
        // Par défaut on attribue le rôle 'ROLE_USER' aux nouveaux utilisateurs
        // Ce rôle est créé automatiquement au lancement de l'application
        Role normal = roleRepository.findByName("ROLE_USER").orElseThrow();
        // On crypte le mot de passe avant de l'enregistrer
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.getRoles().add(normal);
        userRepository.save(user);
    }

    @Override
    public Proprietaire findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void initializeRolesAndAdmin() {
        if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            log.info("Création des deux rôles et de l'administrateur");
            Role roleAdmin = new Role("ROLE_ADMIN");
            Role roleUser = new Role("ROLE_USER");
            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
<<<<<<< HEAD
            Proprietaire firstAdmin = new Proprietaire(adminLogin, adminPassword, adminEmail, null, null, null);
=======
            Proprietaire firstAdmin = new Proprietaire(adminUsername, adminPassword, adminEmail, adminPrenom);
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
            // On crypte le mot de passe avant de l'enregistrer
            firstAdmin.setPassword(bCryptPasswordEncoder.encode(firstAdmin.getPassword()));
            firstAdmin.getRoles().add(roleAdmin);
            userRepository.save(firstAdmin);
        }
    }
}
