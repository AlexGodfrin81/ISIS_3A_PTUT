/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;
import yucroq.entity.Espece;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yucroq.dto.CroquettesPourAnimal;
import yucroq.dto.Animaux;
import yucroq.dto.RechercheCroquettes;
import yucroq.entity.Croquette;

public interface CroquetteRepository extends JpaRepository<Croquette, Integer> {
    
    @Query("SELECT DISTINCT c.id_croq as idcroq, c.nom as nomcroq, c.marque as marquecroq, c.espece as espece "
            + "FROM Ration r " 
            + "JOIN r.mesCroqs c "
            + "JOIN r.consommateur a "
            + "WHERE a.id_animal = :idanimal ")
    public List<CroquettesPourAnimal> listeCroquettesPour(Integer idanimal);
    
    @Query("SELECT a.id_animal as idanimal, a.nom as nomanimal, a.espece as espece "
            + "FROM Animal a "
            + "WHERE a.id_animal <> :idanimal AND a.proprio.id_proprio = :idproprio")
    public List<Animaux> listeAnimaux(Integer idanimal, Integer idproprio);
    
    @Query("SELECT DISTINCT c.id_croq as idcroq, c.marque as marque, c.nom as nom, c.espece as espece "
            + "FROM Ration r " 
            + "JOIN r.mesCroqs c "
            + "JOIN r.consommateur a "
            + "WHERE LOWER(CONCAT(c.marque,' ',c.nom)) LIKE LOWER(CONCAT('%',:recherche,'%')) "
            + "AND c.espece IN (SELECT a.espece as espece FROM Animal a WHERE a.id_animal = :idanimal)")
    public List<RechercheCroquettes> rechercheCroquettes(String recherche, Integer idanimal);
}
