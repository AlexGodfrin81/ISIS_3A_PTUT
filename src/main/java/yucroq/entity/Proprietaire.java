package yucroq.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Proprietaire {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proprio;
    
    @NonNull
    private String nom;
    
    @NonNull
    private String prenom;
    
    @NonNull
    private String tel;
    
    @Column(unique=true)
    @NonNull
    private String email;

    //-== Mapping ==-

    @OneToMany(mappedBy = "proprio")
    @NonNull
    private List<Animal> mesAnimaux = new LinkedList<>(); 

    //-=============-
    
}
