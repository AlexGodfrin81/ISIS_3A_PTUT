/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.swing.Spring;
import lombok.NonNull;

/**
 *
 * @author agath
 */
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_activite;
    
    @Column(unique=true)
    @NonNull
    private Spring nom;
    
    @OneToMany(mappedBy = "monActivite")
    private List<Animal> animauxActivite = new LinkedList<>();
    
}
