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
<<<<<<< HEAD
=======
// Lombok
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
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
<<<<<<< HEAD
=======

>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
    @NonNull // Lombok
    // Contraintes de taille
    @Size(min = 6, max = 32)
    private String username;

    @NonNull // Lombok
    private String password;

    @NonNull // Lombok
    @Email // Doit avoir la forme d'une adresse email
    private String email;

<<<<<<< HEAD
    @NonNull
=======
    @Transient // Non enregistré dans la BD
    private String passwordConfirm;

>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
    private String nom;

    @NonNull
    private String prenom;

<<<<<<< HEAD
    @NonNull
    private String tel;

    @Transient // Non enregistré dans la BD
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    private List<Role> roles = new LinkedList<>();

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

=======
    private String tel;

    //-== Mapping ==-
    @OneToMany(mappedBy = "proprio")
    @NonNull
    private List<Animal> mesAnimaux = new LinkedList<>();

    //-=============-
    @ManyToMany(fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    private List<Role> roles = new LinkedList<>();

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

>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
    @Override
    public boolean isEnabled() {
        return true;
    }
<<<<<<< HEAD
=======

>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97
}
