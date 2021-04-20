package yucroq.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import yucroq.dao.AnimalRepository;
import yucroq.entity.Animal;
import org.junit.jupiter.api.Test;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.context.annotation.Profile;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class AnimalRepositoryTest {
    @Autowired
    private AnimalRepository animalDAO;

    @Test
    @Sql("test-data.sql")
    public void testPoidsIdeal(){
        Optional<Animal> a1 = animalDAO.findById(100);
        log.info("On calcule le poids ideal de{} en java", a1.get().getNom());
        assertEquals(46.666668f, a1.get().poids_ideal(), 0.001f, 
                "Le poids ideal doit etre de 42,8571f" );
        
    }
    
    @Test
    @Sql("test-data.sql")
    public void testCalculK(){
        Optional<Animal> a1 = animalDAO.findById(100);
        log.info("On calcule le K de{} en java", a1.get().getNom());
        assertEquals(0.64f, a1.get().calcul_K(), 0.001f, 
                "Le K doit etre de 0.8f" );
        
    }
    
    @Test
    @Sql("test-data.sql")
    public void testCalculBE(){
        Optional<Animal> a1 = animalDAO.findById(100);
        log.info("On calcule le BE de{} en java", a1.get().getNom());
        assertEquals(1485.5198f, a1.get().calcul_BE(), 0.001f, 
                "Le BE doit etre de 1 715,8143f" );
        
    }
}
