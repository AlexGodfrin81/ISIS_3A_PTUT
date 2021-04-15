package yucroq.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public void testPoidsIdeal(){
        Animal a1 = animalDAO.findById(1).orElseThrow();
        log.info("On calcule le poids ideal de{} en java", a1.getNom());
        assertEquals(42.8571f, a1.poids_ideal(), 0.001f, 
                "Le poids ideal doit etre de 42,8571f" );
        
    }
    
    @Test
    public void testCalculK(){
        Animal a1 = animalDAO.findById(1).orElseThrow();
        log.info("On calcule le K de{} en java", a1.getNom());
        assertEquals(0.8f, a1.calcul_K(), 0.001f, 
                "Le K doit etre de 0.8f" );
        
    }
    
    @Test
    public void testCalculBE(){
        Animal a1 = animalDAO.findById(1).orElseThrow();
        log.info("On calcule le BE de{} en java", a1.getNom());
        assertEquals(1742.0104f, a1.calcul_BE(), 0.001f, 
                "Le BE doit etre de 1 715,8143f" );
        
    }
}
