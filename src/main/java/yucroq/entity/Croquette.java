package yucroq.entity;

import java.util.List;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    
    @NonNull
    private String nom;
    
    @NonNull
    private String marque;
    
    @NonNull
    @Enumerated(EnumType.STRING)
    private Espece espece;
    
    @NonNull
    private float humidite;
    
    @NonNull
    private float proteines_brutes;
    
    @NonNull
    private float matieres_grasses;
    
    @NonNull
    private float cellulose;
    
    @NonNull
    private float matieres_minerales;
    
    @NonNull
    private float calcium;
    
    @NonNull
    private float phosphore;

    //-== Mapping ==-
       
    @OneToMany(mappedBy = "mesCroqs")
    @NonNull
    private List<Ration> rationCroq;
    
    //-=============-
    
    public float densite_Energetique(){
        float ENA=100-(proteines_brutes+matieres_grasses+matieres_minerales+humidite);//fibre ?  Ms–Mn–MAT (matière azotée totale)–MG-CB  
        float EB=(float) ((5.7*this.proteines_brutes)+(9.4*this.matieres_grasses)+(4.1*this.cellulose)+ENA); // EB --> Energie Brute MANQUE ENA
        float dE=1;
        
        switch(this.espece){
            case CHIEN:
                dE=(float) (91.2-(1.43*cellulose)); // digestibilité de l'energie Chien
                break;
            case CHAT:
                dE=(float) (87.9-(0.88*cellulose));// digestibilité de l'energie Chat
                break;
        }
        float Ed=EB*(dE/100);//Energie digestive
        
        float EM=1;// Energie Metabolisable/Densité Energetique
        
        switch(this.espece){
            case CHIEN:
                EM=(float) (Ed-(1.04*proteines_brutes)); // Densité Energetique Chien
                break;
            case CHAT:
                EM=(float) (Ed-(0.77*proteines_brutes));// Densité Energetique Chat
                break;
        }
        return EM;
    }
}
