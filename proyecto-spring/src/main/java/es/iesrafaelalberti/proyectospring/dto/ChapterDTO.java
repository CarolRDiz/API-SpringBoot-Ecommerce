package es.iesrafaelalberti.proyectospring.dto;

import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Lesson;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDTO {
    private Long id ;
    private String title;
    private Set<Lesson> lessons;

    public ChapterDTO(Chapter chapter) {
        this.id = chapter.getId();
        this.title = chapter.getTitle();
        this.lessons = chapter.getLessons();
    }
}
