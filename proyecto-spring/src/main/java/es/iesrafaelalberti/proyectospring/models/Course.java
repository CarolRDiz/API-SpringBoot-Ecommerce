package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title;
    private String subtitle;
    private String description;
    private String requirements;
    private Set<String> teaches = new HashSet<>();
    private Set<String> includes = new HashSet<>();
    private Integer price;
    private boolean enabled = false;

    //TODO
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    @ManyToOne
    private Category category;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Users author;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Lesson> lessons =  new HashSet<>();

    public Course(String title, Users author) {
        this.title = title;
        this.author = author;
    }
}
