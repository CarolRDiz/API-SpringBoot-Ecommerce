package es.iesrafaelalberti.proyectospring.dto;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateDTO implements Serializable {
    private String title;
    private Integer price;
}