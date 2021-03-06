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
    
    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void testMethodeDensiteEnergetique(){
        Optional<Croquette> croq = croquetteDAO.findById(1);
        log.info("On calcule la densite énergetique de la croquette {} en java", croq.get().getNom());
        assertEquals(3550.7178f, croq.get().densite_Energetique(), 0.001f, 
                "La densite energetique de ces croquettes est de 3550.7178" );
        
    }
    
}
