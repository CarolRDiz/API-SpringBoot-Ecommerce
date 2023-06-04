package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Getter @Setter @NoArgsConstructor
public class Users extends ElvisEntity{
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDateTime created;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
     */

/*
    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
 */
    //private Set<CoursePurchase> coursePurchases = new HashSet<>();


    public Users(String name, String surname, String email, String password) {
        this.name       = name;
        this.surname    = surname;
        this.email      = email;
        this.password   = password;
    }
/*
    public Users(UsersCreateDTO newUsers) {
        this.name       = newUsers.getName();
        this.surname    = newUsers.getSurname();
        this.email      = newUsers.getEmail();
        this.password   = newUsers.getPassword();
    }

 */
}
