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
 * @author joffreyviemondesplanque
 */

@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Ration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ration;
    
    @Column
    @NonNull
    private float quantite;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_debut;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_fin;
    
     //-== Mapping ==-
    
    @ManyToOne(optional = false)
    @JoinColumn(name="consommateur")
    private Animal consommateur;

    @ManyToOne(optional = false)
    @JoinColumn(name="mescroqs")
    private Croquette mesCroqs;
    
    
    public float qte_aliment_kg(){
        return consommateur.calcul_BE()/this.mesCroqs.densite_Energetique();
    }
}
