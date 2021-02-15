package entity;

import java.time.LocalDate;
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
public class SuiviPoids {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_suivi;
    
    @Column(unique=true)
    @NonNull
    private LocalDate date;
    
    @Column(unique=true)
    @NonNull
    private Integer poids_kg;
    
}
