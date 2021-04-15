/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

import yucroq.entity.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
    Proprietaire findByUsername(String name);
}

