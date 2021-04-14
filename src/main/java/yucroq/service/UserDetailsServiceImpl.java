package yucroq.service;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
=======
import yucroq.dao.UserRepository;
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
import yucroq.entity.Proprietaire;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
import yucroq.dao.ProprietaireRepository;
=======
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
<<<<<<< HEAD
    private final ProprietaireRepository userRepository;

    public UserDetailsServiceImpl(ProprietaireRepository userRepository) {
=======
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Proprietaire user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        return user;
    }
}
