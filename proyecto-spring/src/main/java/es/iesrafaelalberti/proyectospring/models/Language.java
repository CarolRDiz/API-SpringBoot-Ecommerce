package es.iesrafaelalberti.proyectospring.models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
@Getter
@Setter
@NoArgsConstructor
public class Language {
    @Id
    private long id;
}
