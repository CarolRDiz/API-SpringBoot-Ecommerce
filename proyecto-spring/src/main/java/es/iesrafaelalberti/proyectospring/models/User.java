package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Entity @Getter @Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    //@JsonBackReference
    //@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    //private Set<Prisoner> prisoners = new HashSet<>();

    public User() {}

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}