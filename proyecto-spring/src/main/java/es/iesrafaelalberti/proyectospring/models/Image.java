package es.iesrafaelalberti.proyectospring.models;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "images")
@NoArgsConstructor @Getter @Setter
public class Image {
    @Id
    private long id;

    private String title;

    private Binary image;

    public Image(String title) {
        this.title = title;
    }
}