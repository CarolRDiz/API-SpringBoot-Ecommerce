package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter @NoArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<CoursePurchase> coursePurchases = new HashSet<>();
    /*
    @OneToMany(mappedBy = "users")
    Set<CoursePurchase> purchases;
*/
    public Users(String name, String surname, String email, String password) {
        this.name       = name;
        this.surname    = surname;
        this.email      = email;
        this.password   = password;
    }

    public Users(UsersCreateDTO newUsers) {
        this.name       = newUsers.getName();
        this.surname    = newUsers.getSurname();
        this.email      = newUsers.getEmail();
        this.password   = newUsers.getPassword();
    }
}
