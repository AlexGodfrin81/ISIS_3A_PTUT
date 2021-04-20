package yucroq.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    
    @Column
    @NonNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date_suivi;
    
    @Column
    @NonNull
    private float poids_kg;

    //-== Mapping ==-

    @ManyToOne(optional = false)
    @JoinColumn(name="id_animal")
    private Animal animalPese; 

    //-=============-

}
