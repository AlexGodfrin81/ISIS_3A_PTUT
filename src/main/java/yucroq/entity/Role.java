<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yucroq.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
=======
package yucroq.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
>>>>>>> 7747a35da5b0022b46dbe169213f503ad2c49a97

@Entity
// Lombok
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @NonNull
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<Proprietaire> users = new LinkedList<>();
}
