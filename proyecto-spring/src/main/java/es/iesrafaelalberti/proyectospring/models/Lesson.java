package es.iesrafaelalberti.proyectospring.models;

import com.mongodb.internal.connection.Time;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson extends ElvisEntity{
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private Long id ;
    private String video_id;
    private String title;
    private Integer duration;

    public Lesson(Long id, String video_id, String title, Integer duration) {
        this.id = id;
        this.video_id = video_id;
        this.title = title;
        this.duration = duration;
    }
    public Lesson(String video_id, String title,Integer duration) {
        this.id = 0L;
        this.video_id = video_id;
        this.title = title;
        this.duration = duration;
    }
}
