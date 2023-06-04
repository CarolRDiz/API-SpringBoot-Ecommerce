package es.iesrafaelalberti.proyectospring.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Long id;
    private String url;
    private String title;
    private Integer duration;
    private Long chapter_id;
}
