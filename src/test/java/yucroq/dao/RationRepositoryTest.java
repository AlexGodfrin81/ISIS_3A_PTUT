/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.dao;

/**
 *
 * @author leand
 */
import lombok.extern.log4j.Log4j2;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import yucroq.dao.RationRepository;
import yucroq.entity.Ration;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class RationRepositoryTest {
    
    @Autowired
    private RationRepository rationDAO;
    
    @Test
    //@Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void testMethodeDensiteEnergetique(){
        Ration r1 = rationDAO.findById(1).orElseThrow();
        log.info("On calcule la ration de la croquette {} en java", r1.getId_ration());
        assertEquals(0.4833f, r1.qte_aliment(), 0.001f, 
                "La ration de ces croquettes est de 0,4761" ); 
        
    }
    
}
