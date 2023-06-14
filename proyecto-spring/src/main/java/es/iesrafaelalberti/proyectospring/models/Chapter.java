package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Chapter extends ElvisEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String video_id;
    private String title;
    private Integer duration;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;


    public Chapter(String video_id, String title, Integer duration, Lesson lesson) {
        this.id = id;
        this.video_id = video_id;
        this.title = title;
        this.duration = duration;
        this.lesson = lesson;
    }


}
