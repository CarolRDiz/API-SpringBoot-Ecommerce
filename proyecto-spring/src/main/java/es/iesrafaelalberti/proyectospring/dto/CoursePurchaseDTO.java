package es.iesrafaelalberti.proyectospring.dto;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.CoursePurchase;
import es.iesrafaelalberti.proyectospring.models.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Setter
@AllArgsConstructor
@NoArgsConstructor @Getter
public class CoursePurchaseDTO implements Serializable {
    private Long id;
    private Set<Course> courses;
    private Users user;
    private LocalDateTime purchasedAt;
    public CoursePurchaseDTO(CoursePurchase coursePurchase) {
        this.id                 = coursePurchase.getId();
        this.courses             = coursePurchase.getCourses();
        this.user               = coursePurchase.getUser();
        this.purchasedAt        = coursePurchase.getPurchasedAt();
    }
}