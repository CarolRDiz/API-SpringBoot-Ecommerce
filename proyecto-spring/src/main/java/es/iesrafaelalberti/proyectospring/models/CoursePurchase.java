package es.iesrafaelalberti.proyectospring.models;

import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CoursePurchaseCreateDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Entity @Getter @Setter @NoArgsConstructor
@Table(name = "course_purchase")
public class CoursePurchase {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn()
    private Course course;

    @ManyToOne
    @JoinColumn()
    private Users user;
    //@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date purchasedAt;
    public CoursePurchase(Course course, Users user) {
        this.course = course;
        this.user = user;
    }
    public CoursePurchase(CoursePurchaseCreateDTO newCoursePurchase) {
        this.course             = newCoursePurchase.getCourse();
        this.user               = newCoursePurchase.getUser();
    }
}