package es.iesrafaelalberti.proyectospring.dto;

import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Long id ;
    private String title;
    private Set<Chapter> chapters;
    private Long course_id;

    public LessonDTO(Lesson lesson) {
        this.id = lesson.getId();
        this.title = lesson.getTitle();
        this.chapters = lesson.getChapters();
        this.course_id = lesson.getCourse().getId();
    }
}
