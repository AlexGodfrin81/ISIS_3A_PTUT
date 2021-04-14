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

import org.springframework.test.context.jdbc.Sql;
import yucroq.dao.CroquetteRepository;
import yucroq.entity.Croquette;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class CroquetteRepositoryTest {
    @Autowired
    private CroquetteRepository croquetteDAO;
    
    /*@Test
    public void testMethodeDensiteEnergetique(){
        Croquette croq = croquetteDAO.findById(1).orElseThrow();
        log.info("On calcule la densite énergetique de la croquette {} en java", croq.getNom());
        assertEquals(34.544f, croq.densite_Energetique(), 0.001f, 
                "La densite energetique de ces croquettes est de 34.544f" );
        
    }*/
    
}
