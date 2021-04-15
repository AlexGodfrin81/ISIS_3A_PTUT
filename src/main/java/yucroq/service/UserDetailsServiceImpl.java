package yucroq.service;

import lombok.extern.slf4j.Slf4j;
import yucroq.dao.ProprietaireRepository;
import yucroq.entity.Proprietaire;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yucroq.dao.ProprietaireRepository;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ProprietaireRepository userRepository;

    public UserDetailsServiceImpl(ProprietaireRepository userRepository) {
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
