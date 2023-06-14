package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "users")
public class Users extends ElvisEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDateTime created;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();
    private boolean admin;



    @JsonManagedReference
    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Course> createdCourses = new HashSet<>();

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
     */

/*
    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
 */
    //private Set<CoursePurchase> coursePurchases = new HashSet<>();


    public Users(String username, String name, String surname, String email, String password, boolean admin) {
        this.username = username;
        this.name       = name;
        this.surname    = surname;
        this.email      = email;
        this.password   = password;
        this.admin = admin;
    }

    public Users(Long id, String username, String surname, String password, boolean admin) {
        this.id = id;
        this.username = username;
        this.surname    = surname;
        this.password = password;
        this.admin = admin;
    }
    /*
    public Users(RegistrationDTO newUsers) {
        this.name       = newUsers.getName();
        this.surname    = newUsers.getSurname();
        this.email      = newUsers.getEmail();
        this.password   = newUsers.getPassword();
    }

 */
}
