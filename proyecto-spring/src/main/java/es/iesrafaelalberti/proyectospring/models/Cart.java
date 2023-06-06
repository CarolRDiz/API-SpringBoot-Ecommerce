package es.iesrafaelalberti.proyectospring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn()
    private Course course;
    @ManyToOne
    @JoinColumn()
    private Users user;
}
