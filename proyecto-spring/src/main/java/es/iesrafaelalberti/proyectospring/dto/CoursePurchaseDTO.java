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
import java.util.Date;


@Setter
@AllArgsConstructor
@NoArgsConstructor @Getter
public class CoursePurchaseDTO implements Serializable {
    private Long id;
    private Course course;
    private Users user;
    private Date purchasedAt;
    public CoursePurchaseDTO(CoursePurchase coursePurchase) {
        this.id                 = coursePurchase.getId();
        this.course             = coursePurchase.getCourse();
        this.user               = coursePurchase.getUser();
        this.purchasedAt        = coursePurchase.getPurchasedAt();
    }
}