package yucroq.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALEX
 */
@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_animal;
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    @Enumerated(EnumType.STRING)
    private Espece espece;
    
    @Column(unique=true)
    @NonNull
    private boolean est_Male;
    
    @Column(unique=true)
    @NonNull
    private LocalDate date_naiss;
    
    @Column(unique=true)
    @NonNull
    private Integer taille_cm;
    
    @Column(unique=true)
    @NonNull
    private Integer nec; 
    
    //-== Mapping ==-

    @ManyToOne
    @NonNull
    private Croquette mesCroqs;
    
    @ManyToOne
    @NonNull
    private Proprietaire proprio; 
    
    @OneToMany(mappedBy = "animalPese")
    private List<SuiviPoids> mesPoids = new LinkedList<>(); 

    @ManyToOne
    @NonNull
    private Race maRace ;
    
    @ManyToOne
    @NonNull
    private Activite monActivite; 
    
    @ManyToOne
    @NonNull
    private StadePhysiologique monStadePhysio; 
    
    //-=============-
    
    public float poids_ideal(){
        return this.mesPoids.get(0)
    }
    
}
