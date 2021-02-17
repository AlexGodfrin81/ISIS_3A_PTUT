package yucroq.entity;

import java.util.List;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Croquette {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_croq;
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String marque;
    
    @Column(unique=true)
    @NonNull
    private String espece;
    
    @Column(unique=true)
    @NonNull
    private Integer humidite_pourcent;

    //-== Mapping ==-
    
    @OneToOne(mappedBy = "croq")
    @NonNull
    private Composition composant;  
    
    @OneToMany(mappedBy = "mesCroqs")
    @NonNull
    private List<Animal> animaux = new LinkedList<>();
    
    //-=============-
    
}
