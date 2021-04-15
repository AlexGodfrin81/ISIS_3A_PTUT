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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    
    @NonNull
    private String nom;
    
    @NonNull
    @Enumerated(EnumType.STRING)
    private Espece espece;
    
    @NonNull
    private boolean est_Male;
    
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_naiss;
    
    @NonNull
    private Integer taille_cm;
    
    @NonNull
    private Integer nec; // de 1 à 9
    
    //-== Mapping ==-

    @OneToMany(mappedBy = "consommateur")
    @NonNull
    private List<Ration> mesRations = new LinkedList<>();
    
    @ManyToOne(optional = false)
    @JoinColumn(name="id_proprio")
    private Proprietaire proprio; 
    
    @OneToMany(mappedBy = "animalPese")
    private List<SuiviPoids> mesPoids = new LinkedList<>(); 

    @ManyToOne(optional = false)
    @JoinColumn(name="id_race")
    private Race maRace;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="id_activite")
    private Activite monActivite; 
    
    @ManyToOne(optional = false)
    @JoinColumn(name="id_stade")
    private StadePhysiologique monStadePhysio; 
    
    //-=============-
    
    public List<Ration> getRations() {
        return mesRations;
    }
    
    public float poids_ideal(){
        float poidsO=this.mesPoids.get(0).getPoids_kg();
        System.out.println("poids:"+poidsO);
        float coef=(float)100/(100+(this.getNec()-5));
        System.out.println("coef:"+coef);
        float poidsI=poidsO*coef;
        System.out.println("poids idéal:"+poidsI);
        return poidsI;
    }
    
    // Calcule le coefficient K de l'animal
    public float calcul_K(){
        float K;
        float k1=this.maRace.getK1();
        float k2=this.monActivite.getK2();
        float k3=this.monStadePhysio.getK3();
        // A changer au besoin
        // coeff déterminé en fonction état de santé de l'animal
        // on considère tous les animaux en bonne santé donc k4=1
        float k4=1;
        // coeff déterminé en fonction de la température de l'environnement
        // peu utilisé et difficile à évaluer --> k5=1
        float k5=1;
        K = k1*k2*k3*k4*k5;
        
        // Si K < 0,5, il est recommandé de le fixer à 0,5
        // (pas de chute de poids trop brutale)
        if (K > 0.5) {
            return K;
        }
        else {
            return (float) 0.5;
        }
    }

    /**
     * Calcule le besoin énergétique BE d'un animal.
     * @return le besoin énergétique, en fonction du coefficient K et du besoin énergétique à l'entretien
     */
    
    public float calcul_BE(){
        // La formule est : BE = A * P_idéal ^ B
        // Si l'animal est un chat adulte, A = 100 et B = 0.67
        // Si l'animal est un chien adulte, A = 130 et B = 0.75
        double A;
        double B;
        
        if (Espece.CHAT==this.espece) {
            A = 100;
            B = 0.67;
        }
        else {
            A = 130;
            B = 0.75;
        }
        double BEE = A * Math.pow((double)(poids_ideal()),B);   
        return (float)BEE*calcul_K();
    }
}
