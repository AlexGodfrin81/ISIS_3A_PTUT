/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @NonNull // Lombok
    // Contraintes de taille
    @Size(min = 6, max = 32)
    private String username;

    @NonNull // Lombok
    private String password;

    @NonNull // Lombok
    @Email // Doit avoir la forme d'une adresse email
    private String email;

    @Transient // Non enregistré dans la BD
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    private List<Role> roles = new LinkedList<>();

}
