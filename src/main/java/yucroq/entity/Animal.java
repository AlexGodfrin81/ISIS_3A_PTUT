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
        return this.mesPoids.get(0).getPoids_kg()*(100/(100+(this.getNec()-5)));
    }
    
    /**
     * Calcule le besoin énergétique BE d'un animal.
     * @return le besoin énergétique, en fonction du coefficient K et du besoin énergétique à l'entretien
     */
    public float calcul_BE(){
        // si l'espèce est un chat, alors la puissance sera de 0.67, pour un chien 0.75
        // attention, à changer si on rajoute une espèce (switch case)
        double BE= Math.pow((double)(poids_ideal()), (Espece.CHAT==this.espece)?0.67:0.75); 
        float k1=this.maRace.getK1();
        float k2=this.monActivite.getK2();
        float k3 =this.monStadePhysio.getK3();
        // A changer au besoin
        // coeff déterminé en fonction état de santé de l'animal
        // on considère tous les animaux en bonne santé donc k4=1
        float k4=1;
        // coeff déterminé en fonction de la température de l'environnement
        // peu utilisé et difficile à évaluer --> k5=1
        float k5=1;
        return (float)BE*k1*k2*k3*k4*k5;
    }
    
    public float qte_aliment_kg(){
        return calcul_BE()/this.mesCroqs.densite_Energetique();
    }
    
}
