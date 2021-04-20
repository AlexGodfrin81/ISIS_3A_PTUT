/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import yucroq.entity.Ration;

/**
 *
 * @author ALEX
 */
public interface RationRepository extends JpaRepository<Ration, Integer> {
    /**
     * Modifie la date de fin selon ce qu'à rentrer l'utilisateur
     * @param id l'id de la ration à modifier
     * @param datefin la date de fin de la ration, à changer
     */
   /* @Transactional
    @Query("UPDATE Ration "
            +"SET date_fin=TO_CHAR('2020-04-04', 'YYYY-MM-DD') "
            +"WHERE id_ration=:id")  
    @Modifying  */
    @Transactional
    @Query("update Ration set date_fin=TO_CHAR(:datefin, 'YYYY-MM-DD') where id_ration=:id")  
    @Modifying 

    public void updateRationFin( LocalDate datefin, Integer id);//, LocalDate datefin);
    // Version SQL natif: exprimée en terme du modèle logique de données
    // @Query(value="UPDATE Ration SET date_fin=:datefin WHERE id_ration=:id", nativeQuery = true)  
}
