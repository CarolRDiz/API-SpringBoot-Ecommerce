package es.iesrafaelalberti.proyectospring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonCreateDTO {
    //private Long charapter_id;
    private Long id;
    private MultipartFile video;
    private String title;
    private Integer duration;
    private Long chapter_id;
}
