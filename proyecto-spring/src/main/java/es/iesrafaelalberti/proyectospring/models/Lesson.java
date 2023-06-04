package es.iesrafaelalberti.proyectospring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mongodb.internal.connection.Time;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson extends ElvisEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String video_id;
    private String title;
    private Integer duration;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Chapter chapter;


    public Lesson(String video_id, String title, Integer duration, Chapter chapter) {
        this.id = id;
        this.video_id = video_id;
        this.title = title;
        this.duration = duration;
        this.chapter = chapter;
    }


}
