package es.iesrafaelalberti.proyectospring.models;

import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CoursePurchaseCreateDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

 @Getter @Setter @NoArgsConstructor
@Document(collection = "course_purchases")
public class CoursePurchase {
     @Id
     private long id;
    /*@ManyToOne
    @JoinColumn()
    private Course course;
    */
    private Set<Course> courses;

    /*
    @ManyToOne
    @JoinColumn()
     */
    private Users user;
    //@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private LocalDateTime purchasedAt;

    public CoursePurchase(Set<Course> courses, Users user) {
        this.courses = courses;
        this.user = user;
    }
    public CoursePurchase(CoursePurchaseCreateDTO newCoursePurchase) {
        this.courses             = newCoursePurchase.getCourses();
        this.user               = newCoursePurchase.getUser();
    }
}