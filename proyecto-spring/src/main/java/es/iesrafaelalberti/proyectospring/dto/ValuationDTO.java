package es.iesrafaelalberti.proyectospring.dto;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.models.Valuation;
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
    public ValuationDTO(Valuation valuation) {
        this.id                 = valuation.getId();
        this.course             = valuation.getCourse();
        this.user               = valuation.getUser();
        this.content            = valuation.getContent();
        this.score              = valuation.getScore();
        this.purchasedAt        = valuation.getPurchasedAt();
    }
}