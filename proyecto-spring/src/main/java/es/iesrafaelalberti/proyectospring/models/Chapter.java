package es.iesrafaelalberti.proyectospring.models;

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
    @OneToMany(
            mappedBy = "chapter",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Lesson> lessons = new HashSet<>();

    public Chapter(Long id, String title, Set<Lesson> comments) {
        this.id = id;
        this.title = title;
        this.lessons = comments;
    }

    public Chapter(ChapterCreateDTO newChapter) {
        this.title = newChapter.getTitle();
    }
}
