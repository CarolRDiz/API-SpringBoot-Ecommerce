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
public class CourseDTO {
    private Long id ;
    private String title;
    private Set<Chapter> chapters;

}
