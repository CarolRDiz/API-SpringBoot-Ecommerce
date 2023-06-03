package es.iesrafaelalberti.proyectospring.dto;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.models.UserReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Setter
@AllArgsConstructor
@NoArgsConstructor @Getter
public class ValuationDTO implements Serializable {
    private Long id;
    private Course course;
    private Users user;
    private String content;
    private Double score;
    private Date purchasedAt;
    public ValuationDTO(UserReview userReview) {
        this.id                 = userReview.getId();
        this.course             = userReview.getCourse();
        this.user               = userReview.getUser();
        this.content            = userReview.getContent();
        this.score              = userReview.getScore();
        this.purchasedAt        = userReview.getPurchasedAt();
    }
}