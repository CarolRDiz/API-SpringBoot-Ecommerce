package es.iesrafaelalberti.proyectospring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterCreateDTO {
    private Long course_id;
    private String title;
}
