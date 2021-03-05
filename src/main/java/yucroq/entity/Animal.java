package yucroq.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private String espece;
    
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
    private NEC maNEC; 
    
    @ManyToOne
    @NonNull
    private Activite monActivite; 
    
    @ManyToOne
    @NonNull
    private StadePhysiologique monStadePhysio; 
    
    //-=============-
    
    /* À discuter : Activité et Stade physio dans 2 tables à part
       et Besoin_énergétique/coefficient K à ne pas mettre dans la table
       car calculable à partir des autres attributs 
       
       À faire : - Modifier le MCD du 08/02/21 pour préciser les tables statiques
                   Activité et Stade_physiologique
    
                 - Commencer les mapping "OneToMany", "ManyToOne", etc... 
       
                 - Rajouter les attributs de "Composition" dans entité "Animal" (voir MCD du 08/02/21) */
    
    
}
