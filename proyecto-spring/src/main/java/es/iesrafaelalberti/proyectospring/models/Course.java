package es.iesrafaelalberti.proyectospring.models;

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
    private Integer price;
    //TODO
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    @ManyToOne
    @JoinColumn()
    private Category category;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Chapter> chapters =  new HashSet<>();

}
