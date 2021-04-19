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
import yucroq.dto.PoidsPourAnimal;


public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    
    // Une requête qui renvoie une liste de DTO (Data Transfer Object)
    @Query("SELECT c.id_croq as idcroq, c.marque as marquecroq, c.nom as nomcroq, r.date_debut as datedebut, r.date_fin as datefin, r.quantite as quantiteration, "
            + "CASE WHEN c.espece = 'CHIEN' THEN ((57*c.proteines_brutes + 94*c.matieres_grasses + 41*(100 - c.humidite - c.matieres_minerales - c.proteines_brutes - c.matieres_grasses)) * (91.2-((1.43*c.cellulose)/(1 - c.humidite/100)))/100 - 10.4*c.proteines_brutes) "
            + "WHEN c.espece = 'CHAT' THEN ((57*c.proteines_brutes + 94*c.matieres_grasses + 41*(100 - c.humidite - c.matieres_minerales - c.proteines_brutes - c.matieres_grasses)) * (87.9-((0.88*c.cellulose)/(1 - c.humidite/100)))/100 - 7.7*c.proteines_brutes) END AS densiteenergetique "
            + "FROM Ration r " 
            + "JOIN r.mesCroqs c "
            + "JOIN r.consommateur a "
            + "WHERE a.id_animal = :id ")  
    public List<RationPourAnimal> listeRationsPour(Integer id);
    
    @Query("SELECT sp.date_suivi as date, sp.poids_kg as poids "
            + "FROM SuiviPoids sp " 
            + "JOIN sp.animalPese a "
            + "WHERE a.id_animal = :id ")
    public List<PoidsPourAnimal> listePeseesPour(Integer id);
    
}