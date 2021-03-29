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
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String marque;
    
    @Column(unique=true)
    @NonNull
    @Enumerated(EnumType.STRING)
    private Espece espece;
    
    @Column(unique=true)
    @NonNull
    private float humidite;
    
    @Column(unique=true)
    @NonNull
    private float proteines_brutes;
    
    @Column(unique=true)
    @NonNull
    private float matieres_grasses;
    
    @Column(unique=true)
    @NonNull
    private float cellulose;
    
    @Column(unique=true)
    @NonNull
    private float matieres_minerales;
    
    @Column(unique=true)
    @NonNull
    private float calcium;
    
    @Column(unique=true)
    @NonNull
    private float phosphore;

    //-== Mapping ==-
       
    @OneToMany(mappedBy = "mesCroqs")
    @NonNull
    private List<Animal> animaux = new LinkedList<>();
    
    //-=============-
    
    public float densite_Energetique(){
        float ENA=100-(proteines_brutes+matieres_grasses+matieres_minerales+humidite);//fibre ?  Ms–Mn–MAT (matière azotée totale)–MG-CB
        float EB=(float) ((5.7*this.proteines_brutes)+(9.4*this.matieres_grasses)+(4.1*this.cellulose)+ENA); // EB --> Energie Brute MANQUE ENA
        float dE;
        if(this.espece == Espece.CHIEN){
            dE=(float) (91.2-(1.43*cellulose)); // digestibilité de l'energie Chien
        }
        else {//if(this.espece==Espece.CHAT){//
            dE=(float) (87.9-(0.88*cellulose));// digestibilité de l'energie Chat
        }
        
        float Ed=EB*(dE/100);//Energie digestive
        float EM;// Energie Metabolisable/Densité Energetique
        
        if(this.espece == Espece.CHIEN){
            EM=(float) (Ed-(1.04*proteines_brutes)); // Densité Energetique Chien
        }
        else {//if(this.espece==Espece.CHAT){//
            EM=(float) (Ed-(0.77*proteines_brutes));// Densité Energetique Chat
        }
        return EM;
    }
}
