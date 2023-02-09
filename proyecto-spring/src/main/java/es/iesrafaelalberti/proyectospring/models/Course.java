package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Entity @Getter @Setter
public class Course {
    @Id
    @GeneratedValue
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

    //private Integer number;
    //private Double size;
    //private Integer capacity;

    //@JsonBackReference
    //@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    //private Set<Prisoner> prisoners = new HashSet<>();

    public Course() {}

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
        //this.prisoners = prisoners;
    }
}