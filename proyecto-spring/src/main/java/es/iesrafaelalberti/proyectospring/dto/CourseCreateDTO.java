package es.iesrafaelalberti.proyectospring.dto;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateDTO implements Serializable {
    private String title;
    private String author;
    private Double price;
    private Number hours;
    private Number minutes;
    private String language;
    private String subtitle;
    private String area;
    private String subarea;
    private String level;
}