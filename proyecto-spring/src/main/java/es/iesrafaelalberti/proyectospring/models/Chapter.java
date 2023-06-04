package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
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
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "chapter",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Lesson> lessons = new HashSet<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Chapter(Course course, String title) {
        this.course = course;
        this.title = title;
    }

    public Chapter(ChapterCreateDTO newChapter) {
        this.title = newChapter.getTitle();
    }
}
