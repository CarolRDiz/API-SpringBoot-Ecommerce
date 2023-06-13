package es.iesrafaelalberti.proyectospring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    private String name;

    public Category(@NotNull String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
}
