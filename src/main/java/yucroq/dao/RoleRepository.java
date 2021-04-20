package yucroq.dao;

import yucroq.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long>{
    /**
     * Retourne le rôle correspondant au nom donné
     * @param name le nom du rôle
     * @return le rôle correspondant à name
     */
    Role findByName(String name);
}
