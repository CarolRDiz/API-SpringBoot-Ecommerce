package es.iesrafaelalberti.proyectospring.dto;

import es.iesrafaelalberti.proyectospring.models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id ;
    private String title;
    private Users author;
    private boolean enabled;
    private String video_id;
    private String image_id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
