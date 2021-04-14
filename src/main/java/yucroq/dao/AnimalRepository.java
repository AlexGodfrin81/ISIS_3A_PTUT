/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yucroq.entity.Animal;
import yucroq.dto.RationPourAnimal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    
    // Une requête qui renvoie une liste de DTO (Data Transfer Object)
    @Query("SELECT c.marque as marquecroq, c.nom as nomcroq, r.date_debut as datedebut, r.date_fin as datefin, r.quantite as quantiteration "
            + "FROM Ration r " 
            + "JOIN r.mesCroqs c "
            + "JOIN r.consommateur a "
            + "WHERE a.id_animal = :id ")  
    
    public List<RationPourAnimal> listeRationsPour(Integer id);
}