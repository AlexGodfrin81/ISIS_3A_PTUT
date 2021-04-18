/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yucroq.dto.CroquettesPourAnimal;
import yucroq.entity.Croquette;

public interface CroquetteRepository extends JpaRepository<Croquette, Integer> {
    
    @Query("SELECT DISTINCT c.id_croq as idcroq, c.nom as nomcroq, c.marque as marquecroq "
            + "FROM Ration r " 
            + "JOIN r.mesCroqs c "
            + "JOIN r.consommateur a "
            + "WHERE a.id_animal = :idanimal ")
    public List<CroquettesPourAnimal> listeCroquettesPour(Integer idanimal);
    
    @Query("SELECT a.id_animal as id_animal, a.nom as nom "
            + "FROM Animal a ")
    public List<Object> listeAnimaux();
}
