package es.iesrafaelalberti.proyectospring.models;

import es.iesrafaelalberti.proyectospring.dto.CoursePurchaseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ValuationCreateDTO;
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
@Table(name = "valuation")
public class Valuation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn()
    private Course course;
    @ManyToOne
    @JoinColumn()
    private Users user;
    private String content;
    private Double score;
    //@Column(nullable = false, updatable = false)
    //
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date purchasedAt;
    public Valuation(Course course, Users user, String content, Double score) {
        this.course = course;
        this.user = user;
        this.content = content;
        this.score = score;
    }
    public Valuation(ValuationCreateDTO newValuation) {
        this.course             = newValuation.getCourse();
        this.user               = newValuation.getUser();
        this.content            = newValuation.getContent();
        this.score              = newValuation.getScore();
    }
}