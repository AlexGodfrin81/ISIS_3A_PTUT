/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yucroq.entity.StadePhysiologique;

public interface StadePhysiologiqueRepository extends JpaRepository<StadePhysiologique, Integer> {
    
}
