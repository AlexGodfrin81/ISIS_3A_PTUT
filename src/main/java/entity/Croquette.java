package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    
    
}
