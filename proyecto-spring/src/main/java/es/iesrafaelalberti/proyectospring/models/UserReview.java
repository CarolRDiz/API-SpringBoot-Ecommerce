package es.iesrafaelalberti.proyectospring.models;

import es.iesrafaelalberti.proyectospring.dto.ValuationCreateDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter @Setter @NoArgsConstructor
@Document(collection = "user_reviews")
public class UserReview {
    @Transient
    public static final String SEQUENCE_NAME = "user_review_sequence";
    @Id
    private long id;

    /*
    @ManyToOne
    @JoinColumn()
     */
    private Course course;

    /*
    @ManyToOne
    @JoinColumn()
     */
    private Users user;
    private String content;
    private Double score;
    //@Column(nullable = false, updatable = false)
    //
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date purchasedAt;
    public UserReview(Course course, Users user, String content, Double score) {
        this.course = course;
        this.user = user;
        this.content = content;
        this.score = score;
    }
    public UserReview(ValuationCreateDTO newValuation) {
        this.course             = newValuation.getCourse();
        this.user               = newValuation.getUser();
        this.content            = newValuation.getContent();
        this.score              = newValuation.getScore();
    }
}