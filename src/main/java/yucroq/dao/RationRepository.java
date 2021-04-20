/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import yucroq.entity.Croquette;
import yucroq.entity.Ration;

/**
 *
 * @author ALEX
 */
public interface RationRepository extends JpaRepository<Ration, Integer> {

    /**
     * Modifie la date de fin selon ce qu'à rentrer l'utilisateur
     *
     * @param id l'id de la ration à modifier
     * @param datefin la date de fin de la ration, à changer
     */
    @Transactional
    @Query("update Ration set date_fin=TO_CHAR(:datefin, 'YYYY-MM-DD') where id_ration=:id")
    @Modifying
    public void updateRationFin(LocalDate datefin, Integer id);//, LocalDate datefin);
    // Version SQL natif: exprimée en terme du modèle logique de données
    // @Query(value="UPDATE Ration SET date_fin=:datefin WHERE id_ration=:id", nativeQuery = true)  
    
    /**
     * Ajoute une date de fin aux rations en cours lors de l'ajout d'une nouvelle ration
     * @param idration l'id de la ration ajoutée
     * @param idanimal l'id de l'animal concerné
     * @param datedebut la date de fin de la ration, à changer
     */

    @Transactional
    @Query("update Ration r set date_fin=TO_CHAR(:datedebut, 'YYYY-MM-DD') where r.id_ration <> :idration "
           + "AND r.date_fin IS NULL "
           + "AND r.consommateur IN (SELECT r.consommateur FROM Ration r WHERE r.id_ration = :idration)")
    @Modifying
    public void updateRationDebut ( LocalDate datedebut, Integer idration );
}
