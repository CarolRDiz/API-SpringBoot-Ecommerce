package es.iesrafaelalberti.proyectospring.dto;
import es.iesrafaelalberti.proyectospring.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


@Setter
@AllArgsConstructor
@NoArgsConstructor @Getter
public class CourseDTO implements Serializable {
    private Long id;
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
    private String date;

    //@NotNull
    //private Integer yearsLeft;
    //private Integer cell_number = 0;

    public CourseDTO(Course course) {
        this.id         = course.getId();
        this.title      = course.getTitle();
        this.author     = course.getAuthor();
        this.price      = course.getPrice();
        this.hours      = course.getHours();
        this.minutes    = course.getMinutes();
        this.language   = course.getLanguage();
        this.subtitle   = course.getSubtitle();
        this.area       = course.getArea();
        this.subarea    = course.getSubarea();
        this.level      = course.getLevel();
        this.date       = course.getDate();
        //if(course.getCell() != null)
        //    this.cell_number = course.getCell().getNumber();
    }
}