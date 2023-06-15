package es.iesrafaelalberti.proyectospring.dto;

import es.iesrafaelalberti.proyectospring.models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id ;
    private String title;
    private String subtitle;
    private String description;
    private String requirements;
    private Users author;
    private List<String> teaches ;
    private List<String> includes;
    private boolean enabled;
    private String video_id;
    private String image_id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
