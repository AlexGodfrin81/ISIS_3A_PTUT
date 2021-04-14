<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
package yucroq.dao;

import yucroq.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

<<<<<<< HEAD
public interface RoleRepository extends JpaRepository<Role, Long>{
=======
public interface RoleRepository extends JpaRepository<Role, Long> {
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
    Optional<Role> findByName(String name);
}
