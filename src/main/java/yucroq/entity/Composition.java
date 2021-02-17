package yucroq.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author LEANDRE AGATHE
 */
@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Composition{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_composition;
    
    @Column(unique=true)
    @NonNull
    private String humidite;
    
    @Column(unique=true)
    @NonNull
    private String proteines_brutes;
    
    @Column(unique=true)
    @NonNull
    private String matieres_grasses;
    
    @Column(unique=true)
    @NonNull
    private String cellulose;
    
    @Column(unique=true)
    @NonNull
    private String matiere_minerales;
    
    @Column(unique=true)
    @NonNull
    private String calcium;
    
    @Column(unique=true)
    @NonNull
    private String phosphore;

    //-== Mapping ==-

    @OneToOne
    @NonNull
    private Croquette croq;  

    //-=============-
    
}