/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
// Lombok
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Proprietaire implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id_proprio;

    @NonNull // Lombok
    // Contraintes de taille
    @Size(min = 3, max = 32)
    private String username;

    @NonNull // Lombok
    private String password;

    @NonNull // Lombok
    @Email // Doit avoir la forme d'une adresse email
    private String email;
 
    @NonNull
    private String prenom;

    @NonNull
    @Transient // Non enregistré dans la BD
    private String passwordConfirm;

    @NonNull
    private String nom;

  
    @NonNull
    private String tel;

    @ManyToMany(fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    private List<Role> roles = new LinkedList<>();

    public Proprietaire(String adminUsername, String adminPassword, String adminEmail, String adminPrenom, String adminNom) {
        this.username=adminUsername;
        this.password=adminPassword;
        this.email=adminEmail;
        this.prenom=adminPrenom;
        this.nom=adminNom;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //-== Mapping ==-
    @OneToMany(mappedBy = "proprio")
    @NonNull
    private List<Animal> mesAnimaux = new LinkedList<>();

    //-========= ====-
   
    @Override
    public boolean isEnabled() {
        return true;
    }

}
