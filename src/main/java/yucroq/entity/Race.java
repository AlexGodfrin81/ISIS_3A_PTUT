package yucroq.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author agodfrin
 */
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Race {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_race;
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private Integer coeff_k1;
    
    @Column(unique=true)
    @NonNull
    private String espece;

    //-== Mapping ==-

    @OneToMany(mappedBy = "maRace")
    @NonNull
    private List<Animal> animauxDeRace = new LinkedList<>(); 

    //-=============-
    
}
