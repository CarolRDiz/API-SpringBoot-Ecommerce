package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
@Getter @Setter @NoArgsConstructor
@Document(collection = "courses")
public class Course extends ElvisEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /*
    @JsonBackReference
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<CoursePurchase> coursePurchases = new HashSet<>();
    */
    @ManyToMany
    private Set<CoursePurchase> orders;

    /*
        @OneToMany(mappedBy = "course")
        Set<CoursePurchase> coursePurchases;
        public Course() {}
    */
    public Course(String title, String author, Double price, Number hours, Number minutes, String language, String subtitle, String area, String subarea, String level, String date) {
        //Set<Prisoner> prisoners
        this.title = title;
        this.author = author;
        this.price = price;
        this.hours = hours;
        this.minutes = minutes;
        this.language = language;
        this.subtitle = subtitle;
        this.area = area;
        this.subarea = subarea;
        this.level = level;
        this.date = date;
    }

    public Course(CourseCreateDTO newCourse) {
        this.title      = newCourse.getTitle();
        this.author     = newCourse.getAuthor();
        this.price      = newCourse.getPrice();
        this.hours      = newCourse.getHours();
        this.minutes    = newCourse.getMinutes();
        this.language   = newCourse.getLanguage();
        this.subtitle   = newCourse.getSubtitle();
        this.area       = newCourse.getArea();
        this.subarea    = newCourse.getSubarea();
        this.level      = newCourse.getLevel();
    }
}