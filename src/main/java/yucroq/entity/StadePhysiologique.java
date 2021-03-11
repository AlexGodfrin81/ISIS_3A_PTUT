/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.swing.Spring;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class StadePhysiologique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_stade;
    
    @Column(unique=true)
    @NonNull
    private Spring nom;
    
    @Column(unique=true)
    @NonNull
    private float coeff_k3;
    
    @OneToMany(mappedBy = "monStadePhysio")
    private List<Animal> animauxStadePhysio = new LinkedList<>();
}
