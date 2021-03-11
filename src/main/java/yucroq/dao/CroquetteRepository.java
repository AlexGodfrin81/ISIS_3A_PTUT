/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yucroq.entity.Croquette;

public interface CroquetteRepository extends JpaRepository<Croquette, Integer> {
    
}
