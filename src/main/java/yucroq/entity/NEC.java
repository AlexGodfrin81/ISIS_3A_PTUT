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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class NEC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nec;
    
    @Column(unique=true)
    @NonNull
    @Min(value=1,message="La NEC ne peut être inférieur à 1")
    @Max(value=9,message="La NEC ne peut être supérieur à 9")
    private int valeur;
    
    @OneToMany(mappedBy = "maNEC")
    private List<Animal> animauxNEC = new LinkedList<>();
}
